package models;

public class File {
    private int id;
    private String name;
    Block startBlock;
    long totalSizeInBytes;
    FileMetadata metadata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(Block startBlock) {
        this.startBlock = startBlock;
    }

    public long getTotalSizeInBytes() {
        return totalSizeInBytes;
    }

    public void setTotalSizeInBytes(long totalSizeInBytes) {
        this.totalSizeInBytes = totalSizeInBytes;
    }

    public FileMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(FileMetadata metadata) {
        this.metadata = metadata;
    }
}
