package models.disk;

import java.util.List;

import models.Block;

public class HDisk extends Disk {

    public HDisk(int memorySizeInMB, int blockSizeInBytes) {
        super(memorySizeInMB, blockSizeInBytes);
    }

    @Override
    public byte[] read(Block block) {
        byte[] blockContent = block.getContent();
        return blockContent;
    }

    @Override
    public void write(Block block, byte[] content) {
        block.setContent(content);
    }
}
