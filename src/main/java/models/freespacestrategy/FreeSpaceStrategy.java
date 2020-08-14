package models.freespacestrategy;

import FileSystemException.NotEnoughMemoryException;
import models.Block;

public interface FreeSpaceStrategy {
    void addFreeBlock(Block block);
    Block getNextFreeBlock() throws NotEnoughMemoryException;
}
