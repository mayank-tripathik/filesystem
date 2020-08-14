package models.freespacestrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import FileSystemException.NotEnoughMemoryException;
import models.Block;

public class FreeSpaceStrategyRandom implements FreeSpaceStrategy {
    List<Block> freeBlocksList;

    public FreeSpaceStrategyRandom() {
        this.freeBlocksList = new LinkedList<>();
    }

    @Override
    public void addFreeBlock(Block block){
        freeBlocksList.add(block);
    }

    @Override
    public Block getNextFreeBlock() throws NotEnoughMemoryException {
        if(freeBlocksList.size() == 0) {
            throw new NotEnoughMemoryException("Not enough memory to store this file");
        }
        int index = new Random().nextInt(freeBlocksList.size());
        Block block = freeBlocksList.get(index);
        freeBlocksList.remove(block);
        return block;
    }
}
