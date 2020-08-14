package models.filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import FileSystemException.FileNotFoundException;
import FileSystemException.NotEnoughMemoryException;
import models.Block;
import models.File;
import models.FileMetadata;
import models.freespacestrategy.FreeSpaceStrategy;

public class FileSystemLinked implements FileSystem {

    List<Block> blocks;
    FreeSpaceStrategy freeSpaceStrategy;
    int blockSize;
    TreeMap<String,File> directory;

    public FileSystemLinked(int noOfBlocks, int blockSize, FreeSpaceStrategy freeSpaceStrategy) {
        this.blocks = new ArrayList<>();
        this.freeSpaceStrategy = freeSpaceStrategy;
        this.blockSize = blockSize;
        this.directory = new TreeMap<>();
        for(int i=0;i<noOfBlocks;i++){
            Block block = new Block();
            blocks.add(block);
            freeSpaceStrategy.addFreeBlock(block);
        }
    }

    @Override
    public File create(String name, String content) throws NotEnoughMemoryException {
        byte[] contentBytes = content.getBytes();
        Block startBlock = divideAndStore(contentBytes);
        File newFile = new File();
        FileMetadata fileMetadata = new FileMetadata();
        Date currentTime = new Date();
        fileMetadata.setCreationDate(currentTime);
        fileMetadata.setUpdationDate(currentTime);
        newFile.setName(name);
        newFile.setStartBlock(startBlock);
        newFile.setMetadata(fileMetadata);
        directory.put(name, newFile);
        return newFile;
    }

    @Override
    public String read(String name) throws FileNotFoundException {
        File file = directory.get(name);
        if(file == null){
            throw new FileNotFoundException("File not found");
        }
        Block startBlock = file.getStartBlock();
        String content = fetchFromStartBlock(startBlock);
        return content;
    }

    private Block divideAndStore(byte[] contentBytes) throws NotEnoughMemoryException{
        Block prevFreeBlock = null;
        Block startBlock = null;
        List<Block> occupiedBlocks = new LinkedList<>();
        for(int i=0; i <  contentBytes.length; i = i + blockSize) {
            int maxLimit = Math.min((i+blockSize),contentBytes.length);
            byte[] blockContent = Arrays.copyOfRange(contentBytes, i, maxLimit);
            Block freeBlock = freeSpaceStrategy.getNextFreeBlock();
            if(freeBlock == null){
                occupiedBlocks.forEach(b->{
                    freeSpaceStrategy.addFreeBlock(b);
                });
                return null;
            }
            occupiedBlocks.add(freeBlock);
            freeBlock.setContent(blockContent);
            freeBlock.setFree(false);
            if(prevFreeBlock != null)
                prevFreeBlock.setNextLogicalBlock(freeBlock);
            else
                startBlock = freeBlock;
            prevFreeBlock = freeBlock;
        }
        return startBlock;
    }

    private String fetchFromStartBlock(Block startBlock){
        Block currentBlock = startBlock;
        String fileContent = new String();
        while(currentBlock != null) {
            byte[] subArray = currentBlock.getContent();
            String contentForThisBlock = new String(subArray);
            fileContent = fileContent.concat(contentForThisBlock);
            currentBlock = currentBlock.getNextLogicalBlock();
        }
        return fileContent;
    }

}
