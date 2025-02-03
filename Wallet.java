import java.security.*;
import java.util.*;

public class Wallet {
  public String privateKey;
  public String publicKey;
  private float balance=100.0f;
  private ArrayList<Block2> blockchain = new ArrayList<Block2>();

  public Wallet(ArrayList<Block2> blockchain) {
    generateKeyPair();
    this.blockchain = blockchain;
  }
  public void generateKeyPair() {
    try {
      KeyPair keyPair;
      String algorithm = "RSA";
      keyPair = KeyPairGenerator.getInstance(algorithm).generateKeyPair();
      privateKey = keyPair.getPrivate().toString();
      publicKey = keyPair.getPublic().toString();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  public float getBalance() {
    float total = balance;
    for(int i = 0; i < blockchain.size(); i++) {
      Block2 currentBlock = blockchain.get(i);
      for(int j = 0; j < currentBlock.transactions.size(); j++) {
        Transaction tr = currentBlock.transactions.get(j);
        if(tr.recipient.equals(publicKey)) {
          total += tr.value;
        }
        if(tr.sender.equals(publicKey)) {
          total -= tr.value;
        }
      }
    }
    return total;
  }
  public Transaction send(String recipient, float value) {
    if(getBalance() < value) {
      System.out.println("!!! Not enough funds. Transaction discarded.");
      return null;
    }
    Transaction newTransaction = new Transaction(publicKey, recipient, value);
    return newTransaction;
  }
}
