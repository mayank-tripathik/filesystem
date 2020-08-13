import models.FileAllocationStrategyFCFS;
import models.Memory;

public class FileDriver {
    public static void main(String[] args) {
        Memory memory = new Memory(1,10, new FileAllocationStrategyFCFS());
        memory.addFile("file.txt", "hello");
        memory.addFile("file2.txt", "hello");
        memory.addFile("file3.txt", "hello");
    }
}
