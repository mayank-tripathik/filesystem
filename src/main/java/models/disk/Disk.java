package models.disk;

import models.Block;

public abstract class Disk {
    int memorySizeInMB;
    int blockSizeInBytes;
    int noOfBlocks;

    public Disk(int memorySizeInMB, int blockSizeInBytes) {
        this.memorySizeInMB = memorySizeInMB;
        this.blockSizeInBytes = blockSizeInBytes;
        this.noOfBlocks = getNumberofBlocks();
    }

    public int getMemorySizeInMB() {
        return memorySizeInMB;
    }

    public int getBlockSizeInBytes() {
        return blockSizeInBytes;
    }

    public int getNoOfBlocks() {
        return noOfBlocks;
    }

    private int getNumberofBlocks(){
        int memorySizeinBytes = this.memorySizeInMB * 1000000;
        return (memorySizeinBytes/blockSizeInBytes);
    }

    abstract byte[] read(Block block);
    abstract void write(Block block, byte[] content);
}
