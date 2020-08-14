import FileSystemException.FileNotFoundException;
import FileSystemException.NotEnoughMemoryException;
import models.File;
import models.disk.Disk;
import models.disk.HDisk;
import models.filesystem.FileSystem;
import models.filesystem.FileSystemLinked;
import models.freespacestrategy.FreeSpaceStrategy;
import models.freespacestrategy.FreeSpaceStrategyRandom;

public class FileDriver {
    public static void main(String[] args) {
        Disk disk = new HDisk(1,10);
        FileSystem fileSystem = new FileSystemLinked(disk.getNoOfBlocks(), disk.getBlockSizeInBytes(), new FreeSpaceStrategyRandom());

        // Creating file
        try {
            File file = fileSystem.create("file1.txt", "hello mayank tripathi");
            System.out.println(file.getName());
            System.out.println(file.getMetadata().getCreationDate());
        }catch (NotEnoughMemoryException e){
            System.err.println(e);
        }

        // Reading file
        try {
            String content = fileSystem.read("file1.txt");
            System.out.println("File content :" + content);
        }catch (FileNotFoundException e){
            System.err.println(e);
        }

    }
}
