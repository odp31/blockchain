import java.util.*;

public class BlockChainMain2 {
  public static ArrayList<Block> blockchain = new arrayList<Block>();
  public static int difficulty = 5;

  public static void main(String[] args) {
    Block b = new Block(0, null, "My First Block");
    b.mineBlock(difficulty);
    blockchain.add(b);
    System.out.println(b.toString());
    System.out.println("current block valid: " + validateBlock(b, null));
    Block b2 = new Block(1, b.currentHash, "My second block");
    b2.mineBlock(difficulty);
    blockchain.add(b2);
    //b2.data = "My third block";
    System.out.println(b2.toString());
    System.out.println("Current block valid: " + validateBlock(b2, b));
  }
  public static boolean validateBlock(Block newBlock, Block previousBlock) {
    if(previousBlock == null) {
      if(newBlock.index != 0) {
        return false;
      }
      if(newBlock.previousHash != null) {
        return false;
      }
      if(newBlock.currentHash == null || !newBlock.calculateHash().equals(newBlock.currentHash)) {
        return false;
      }
      return true;
    } else {
      if(newBlock != null) {
        if(previousBlock.index + 1 != newBlock.index) {
          return false;
        }
        if(newBlock.previousHash == null || !newBlock.previousHash.equals(previousBlock.currentHash)) {
          return false;
        }
        if(newBlock.currentHash == null || !newBlock.calculateHash().equals(newBlock.currentHash)) {
          return false;
        }
        return true;
      }
      return false;
    }
  }
}
