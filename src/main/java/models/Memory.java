package models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Memory {
    List<Block> blocks;
    int memorySizeInMB;
    int blockSizeInBytes;
    FileAllocationStrategy fileAllocationStrategy;

    public Memory(int memorySizeInMB, int blockSizeInBytes, FileAllocationStrategy fileAllocationStrategy) {
        this.blockSizeInBytes = blockSizeInBytes;
        this.memorySizeInMB = memorySizeInMB;
        long numberofBlocks = getNumberofBlocks();
        this.fileAllocationStrategy = fileAllocationStrategy;
        blocks = new LinkedList<Block>();
        partitionMemoryIntoBlocks(numberofBlocks);
    }

    private void partitionMemoryIntoBlocks(long numberofBlocks) {
        numberofBlocks = 10;
        while (numberofBlocks > 0){
            blocks.add(new Block());
            numberofBlocks--;
        }
    }

    private long getNumberofBlocks(){
        long memorySizeinBytes = this.memorySizeInMB * 1000000;
        return (memorySizeinBytes/blockSizeInBytes);
    }

    public void memoryInfo(){
        System.out.println("Memeory is : " + memorySizeInMB + "MB with " + blocks.size() + " number of blocks");
    }

    public void addFile(String name, String content){
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        Block firstBlock = fileAllocationStrategy.findFirstFreeBlock(this);
        System.out.println("Saving at : " + firstBlock.getId());
        firstBlock.setContent(contentBytes);
        firstBlock.setFree(false);
        System.out.println(blocks);
    }
}
