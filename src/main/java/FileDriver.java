import FileSystemException.FileNotFoundException;
import FileSystemException.NotEnoughMemoryException;
import models.File;
import models.disk.Disk;
import models.disk.HDisk;
import models.filesystem.FileSystem;
import models.filesystem.FileSystemLinked;
import models.freespacestrategy.FreeSpaceStrategyRandom;

public class FileDriver {
    public static void main(String[] args) {
        Disk disk = new HDisk(1,10);
        FileSystem fileSystem = new FileSystemLinked(disk, new FreeSpaceStrategyRandom());

        // Creating file
        try {
            File file1 = fileSystem.create("file1.txt", "file 1");
            File file2 = fileSystem.create("file2.txt", "file 2 text");
        }catch (NotEnoughMemoryException e){
            System.err.println(e);
        }

        // Reading file
        try {
            System.out.println("File content of file1.txt: " + fileSystem.read("file1.txt"));
            System.out.println("File content of file2.txt: " + fileSystem.read("file2.txt"));
        }catch (FileNotFoundException e){
            System.err.println(e);
        }

        // updating file
        try {
            fileSystem.update("file1.txt", "Updated file 1 content");
            System.out.println("Updated file content of file1.txt: " + fileSystem.read("file1.txt"));
        }catch (FileNotFoundException e){
            System.err.println(e);
        }
        catch (NotEnoughMemoryException e){
            System.err.println(e);
        }

        // deleting file
        try {
            fileSystem.delete("file1.txt");
        }catch (FileNotFoundException e){
            System.err.println(e);
        }

        // reading a deleted file
        try {
            System.out.println(fileSystem.read("file1.txt"));
        }catch (FileNotFoundException e){
            System.err.println(e);
        }

    }
}
