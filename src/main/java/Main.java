
public class Main {
  public static void main(String[] args) {

    BinarySearchTree binarySearchTree = new BinarySearchTree(47);
    binarySearchTree.insert(21);
    binarySearchTree.insert(76);
    binarySearchTree.insert(18);
    binarySearchTree.insert(27);
    binarySearchTree.insert(52);
    binarySearchTree.insert(82);
    System.out.println(binarySearchTree.BFS());
    System.out.println(binarySearchTree.DFSPreOrder());
    System.out.println(binarySearchTree.DFSPostOrder());
    System.out.println(binarySearchTree.DFSInorder());
  }
}