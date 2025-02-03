import java.util.*;

public class BlockChainMain {
  public static ArrayList<Block> blockchain = new ArrayList<Block>();
  public static int difficulty = 5;

  public static void main(String[] args) {
    Block b = new Block(0, null, "My First Block");
    b.mineBlock(difficulty);
    blockchain.add(b);
    System.out.println(b.toString());
    Block b2 = new Block(1, b.currentHash, "My Second Block");
    b2.mineBlock(difficulty);
    blockchain.add(b2);
    System.out.println(b2.toString());
  }
}
