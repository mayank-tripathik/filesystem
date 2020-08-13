package models;

import org.w3c.dom.ls.LSException;

import java.util.List;

public class FileAllocationStrategyFCFS implements FileAllocationStrategy{
    @Override
    public Block findFirstFreeBlock(Memory memory) {
        List<Block> blocks = memory.blocks;
        for(int i=0;i< blocks.size(); i++){
            if(blocks.get(i).isFree){
                return blocks.get(i);
            }
        }
        return null;
    }

    @Override
    public Block findNextFreeBlock(Memory memory, int index) {
        for(int i=index;i<memory.blocks.size(); i++){
            if(memory.blocks.get(i).isFree){
                return memory.blocks.get(i);
            }
        }
        return null;
    }
}
