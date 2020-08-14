import FileSystemException.FileNotFoundException;
import FileSystemException.NotEnoughMemoryException;
import models.disk.Disk;
import models.disk.HDisk;
import models.filesystem.FileSystem;
import models.filesystem.FileSystemLinked;
import models.freespacestrategy.FreeSpaceStrategy;
import models.freespacestrategy.FreeSpaceStrategyRandom;

public class FileDriver {
    public static void main(String[] args) throws NotEnoughMemoryException, FileNotFoundException {
        Disk disk = new HDisk(1,10);
        FileSystem fileSystem = new FileSystemLinked(disk.getNoOfBlocks(), disk.getBlockSizeInBytes(), new FreeSpaceStrategyRandom());
        fileSystem.create("file1.txt","hellomayank");
        System.out.println(fileSystem.read("file1.txt"));

    }
}
