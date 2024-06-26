
import java.util.*;

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree(int value) {
    Node newNode = new Node(value);
    this.root = newNode;
  }

  public BinarySearchTree() {
    this.root = null;
  }

  public Node getRoot() {
    return root;
  }

  public boolean insert(int value) {
    Node newNode = new Node(value);
    Node temp = root;

    if (root == null) {
      root = newNode;
      return true;
    }

    while (true) {
      if (temp.getValue() > value) {
        if (temp.getLeft() == null) {
          temp.setLeft(newNode);
          return true;
        } else {
          temp = temp.getLeft();
        }
      } else if (temp.getValue() < value) {
        if (temp.getRight() == null) {
          temp.setRight(newNode);
          return true;
        } else {
          temp = temp.getRight();
        }
      } else {
        return false;
      }
    }

  }

  private Node rInsert(int value, Node currentNode) {

    if (currentNode == null) {
      return new Node(value);
    }

    if (value < currentNode.getValue()) {
      currentNode.setLeft(rInsert(value, currentNode.getLeft()));
    } else {
      currentNode.setRight(rInsert(value, currentNode.getRight()));
    }

    return currentNode;
  }

  public void rInsert(int value) {
    rInsert(value, root);
  }

  private boolean rContains(Node currentNode, int value) {
    if (currentNode == null) {
      return false;
    } else if (currentNode.getValue() == value) {
      return true;
    }

    if (value < currentNode.getValue()) {
      return rContains(currentNode.getLeft(), value);
    } else {
      return rContains(currentNode.getRight(), value);
    }
  }

  public boolean rContains(int value) {
    return rContains(root, value);
  }

  public boolean contains(int value) {
    Node temp = root;

    while (temp != null) {

      if (temp.getValue() > value) {
        temp = temp.getLeft();
      } else if (temp.getValue() < value) {
        temp = temp.getRight();
      } else {
        return true;
      }
    }
    return false;
  }

  private int minValue(Node currentNode) {
    while (currentNode.getLeft() != null) {
      currentNode = currentNode.getLeft();
    }

    return currentNode.getValue();
  }

  private Node deleteNode(Node currentNode, int value) {

    if (currentNode == null) {
      return null;
    }

    if (value < currentNode.getValue()) {
      currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
    } else if (value > currentNode.getValue()) {
      currentNode.setRight(deleteNode(currentNode.getRight(), value));
    } else {
      if (currentNode.getLeft() == null && currentNode.getRight() == null) {
        return null;
      } else if (currentNode.getLeft() == null) {
        currentNode = currentNode.getLeft();
      } else if (currentNode.getRight() == null) {
        currentNode = currentNode.getRight();
      } else {
        int subTreeMin = minValue(currentNode.getRight());
        currentNode.setValue(subTreeMin);
        currentNode.setRight(deleteNode(currentNode.getRight(), subTreeMin));
      }
    }

    return currentNode;
  }

  public Node deleteNode(int value) {
    return deleteNode(root, value);
  }

  public ArrayList<Integer> BFS() {
    Node currentNode = root;
    Queue<Node> queue = new LinkedList<Node>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    queue.add(currentNode);

    while (queue.size() > 0) {
      currentNode = queue.remove();
      results.add(currentNode.getValue());
      if (currentNode.getLeft() != null) {
        queue.add(currentNode.getLeft());
      }

      if (currentNode.getRight() != null) {
        queue.add(currentNode.getRight());
      }
    }

    return results;

  }

  private void DFSPreOrder(Node current,ArrayList<Integer> results){
    results.add(current.getValue());
    if(current.getLeft() != null){
      DFSPreOrder(current.getLeft(),results);
    }
    if(current.getRight() != null){
      DFSPreOrder(current.getRight(),results);
    }
    
  }
  
  public ArrayList<Integer> DFSPreOrder(){
    ArrayList<Integer> results = new ArrayList<Integer>();
    DFSPreOrder(root, results);

    return results;
  } 

  private void DFSPostOrder(Node current,ArrayList<Integer> results){
    
    if(current.getLeft() != null){
      DFSPostOrder(current.getLeft(),results);
    }
    
    if(current.getRight() != null){
      DFSPostOrder(current.getRight(),results);
    }

    results.add(current.getValue());
  }

  public ArrayList<Integer> DFSPostOrder(){
    ArrayList<Integer> results = new ArrayList<Integer>();
    DFSPostOrder(root, results);

    return results;
  } 

  private void DFSInorder(Node current,ArrayList<Integer> results){

    if(current.getLeft() != null){
        DFSInorder(current.getLeft(),results);
    }
     results.add(current.getValue());
    if(current.getRight() != null){
        DFSInorder(current.getRight(),results);
    }
   
  }

  public ArrayList<Integer> DFSInorder(){
    ArrayList<Integer> results = new ArrayList<Integer>();
    DFSInorder(root, results);

    return results;
  } 

  


  
    
  
}