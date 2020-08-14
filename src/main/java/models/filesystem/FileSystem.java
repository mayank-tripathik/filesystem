package models.filesystem;

import FileSystemException.FileNotFoundException;
import FileSystemException.NotEnoughMemoryException;
import models.File;

public interface FileSystem {
    File create(String name, String content) throws NotEnoughMemoryException;
    String read(String name) throws FileNotFoundException;
    void update(String name, String content) throws FileNotFoundException,NotEnoughMemoryException;
    void delete(String name) throws FileNotFoundException;
}
