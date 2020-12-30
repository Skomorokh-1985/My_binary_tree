package Tree_29_12_2020;

public class Node {

    public Integer key;
    public String value;
    Node leftChild;
    Node rightChild;

    public Node(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }

    @Override
    public String toString()  {
            return "Node {" + "key=" + key + ", value=" + value + "}";
    }

    public void printNode(){
        System.out.println("KEY " + key + " value: " + value);
    }
}
