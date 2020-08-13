package models;

public interface FileAllocationStrategy {
    Block findFirstFreeBlock(Memory memory);
    Block findNextFreeBlock(Memory memory, int index);
}
