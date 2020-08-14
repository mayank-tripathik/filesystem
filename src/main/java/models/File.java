package models;

public class File {
    private String name;
    Block startBlock;
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

    public FileMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(FileMetadata metadata) {
        this.metadata = metadata;
    }
}
