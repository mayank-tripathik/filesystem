package models;

public class File {
    private int id;
    private String name;
    int startBlockId;
    long totalSizeInBytes;
    FileMetadata metadata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartBlockId() {
        return startBlockId;
    }

    public void setStartBlockId(int startBlockId) {
        this.startBlockId = startBlockId;
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
