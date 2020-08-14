package models;

public class Block {
    private static int idCounter = 0;
    private int id;
    private Block nextLogicalBlock;
    private byte[] content;
    private boolean isFree;

    public Block() {
        idCounter++;
        id = idCounter;
        nextLogicalBlock = null;
        content = null;
        isFree = true;
    }

    public int getId() {
        return id;
    }

    public Block getNextLogicalBlock() {
        return nextLogicalBlock;
    }

    public void setNextLogicalBlock(Block nextLogicalBlock) {
        this.nextLogicalBlock = nextLogicalBlock;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString(){
        String contents = "";
        if(content != null){
            contents = new String(content);
        }
        String text = (isFree) ? "FREE" : "OCCUPIED";
        return contents + ":" + text;
    }
}
