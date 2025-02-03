import java.util.*;

public class BlockChainMain4 {
  public static ArrayList<Block2> blockchain = new ArrayList<Block2>();
  public static ArrayList<Transaction> transactions = new public static int difficulty = 5;
  public static void main(String[] args) {
    Wallet A = new Wallet(blockchain);
    Wallet B = new Wallet(blockchain);
    System.out.println("wallet a balance: " + A.getBalance());
    System.out.println("wallet b balance: " + B.getBalance());
  }
}
