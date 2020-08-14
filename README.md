# FileSystem
Following are the various classes with their description:
  - Disk : has api for read and writing to the blocks
  - HDisk : Implementation of disk interface
  - FreeSpaceStrategy : Interface having apis to get nextfreeslot, addfreeslot 
  - FreeSpaceStrategyRandom : Implementation of FreeSpaceStrategy where free block is returned anywhere from the disk if present
  - Block : The unit level class for disk. Each block has capabillity to store content in it and points to nextlogical block
  - File : Logical model of a file, containing file name and metadata
  - FileMetaData : Metdata related to file such as creation and updation time and description
  - FileSystem : Interface having API for create and read file and so on.
  - FileSystemLinked : Implementation of File system using Linked approach.

### Flow

  - We first create the disk with a size and blocksize. This will mimic a mounting operation of disk of given size having fixed number of blocks. Number of blocks is calculated from disk size and blocksize.
  - A new Filesystem implementation will be created then. FileSystemLinked is implemented here. It has to instantiate with FreeSpaceStrategy and blocks in its logical view. While creating the File, it stores the content of file in random blocks and connect these blocks together using nextLogicalBlock field of block. It fetches the free block from the given strategy. The first block will be stored against the File object and mapping of file name and file object will be saved in a map so that while fetching the file, it can be searched against the name quickly. While creating file, freespacestrategy keeps updating it free block info accordingly.
  - Exceptions : At any time , if it is not possible to create file because of less memory or it is not possible to read file because file doesn't exists, appropriate exception will be thrown.

### Rationale
  - Since a actual disk all cares about going to block in constant time and gives the content of that block, disk is implemented as interface. So some other disk hardware comes up, like magentic etc, it can implement its read and write operations on blocks in their own way.
  - FreeSpace is implemented using Strategy pattern and present in the FileSystem class as abstracted strategy so that in future if we come up with other freeStratgey like FCFS, we can plug it and just pass it to FileSystem constructor while initiating.
  - Block, File and FileMetaData is segregated functionality wise, so that changes in one, doesn't forces changes in others
  - FileSystem is expose through APIs. So that if we want to implement different file system implemenation, like index based instead of linked based, we can implement and interface API like create and read will remains the same.
  - Benefit of Linked implementation is that their is no external fragmentation as each block will be used if it is free. Internal fragmentation will be there though.

### Further Improvements
There are many many improvements that can be incorporated : 
  - Storing the current status of open files and their current seek position so that file can be repeteadly read from prev place.
  - Block class can be abstracted to a general class, say Node, so that we can extend it and form special blocks like superblock and index nodes.
  - Data about disk and metadata should be written to disk too in dedicated blocks and address of those blocks can be stored in a super block
  - Adding owner functionality and access right related to files.
  - Making FreeSpaceStrategyRandom more faster as right now it is uing linked list to keep track of free blocks 
  - File model can be improved more

![FileSystem Diagram](/images/filesystem.png)


