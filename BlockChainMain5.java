import java.util.*;

public class BlockChainMain5 {
  public static ArrayList<Block2> blockchain = new ArrayList<Block2>();
  public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
  public static int difficulty = 5;

  public static void main(String[] args) {
    Wallet A = new Wallet(blockchain);
    Wallet B = new Wallet(blockchain);
    System.out.println("Wallet A Balance: " + A.getBalance());
    System.out.println("Wallet B Balance: " + B.getBalance());
    System.out.println("Add two transactions..");
    Transaction tran1 = A.send(B.publicKey, 10);
    if(tran1 != null) {
      transactions.add(tran1);
    }
    Transaction tran2 = A.send(B.publicKey, 20);
    if(tran2 != null) {
      transactions.add(tran2);
    }
    Block2 b = new Block2(0, null, transactions);
    b.mineBlock(difficulty);
    blockchain.add(b);
    System.out.println("Wallet A Balance: " + A.getBalance());
    System.out.println("Wallet B Balance: " + B.getBalance());
    System.out.println("Blockchain Valid: " + validateChain(blockchain));
  }
  public static boolean validateChain(ArrayList<Block2> blockchain) {
    if(!validateBlock(blockchain.get(0), null)) {
      return false;
    }
    for(int i = 1; i < blockchain.size(); i++) {
      Block2 currentBlock = blockchain.get(i);
      Block2 previousBlock = blockchain.get(i - 1); 
      if(!validateBlock(currentBlock, previousBlock)) {
        return false;
      }
    }
    return true;
  }
}
}
