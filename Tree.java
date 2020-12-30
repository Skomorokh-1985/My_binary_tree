package Tree_29_12_2020;

public class Tree {

    public Node root;

    public Tree () {
    }

    public void insertElement (Integer key, String value) {
        Node newElement = new Node();
        newElement.key = key;
        newElement.value = value;
        int iE1 = 0;
        int iE2 = 0;
        int iE3 = 0;
        int iE4 = 0;
        int iE5 = 0;
        int iE6 = 0;

        if (root == null) {
            root = newElement;
            //System.out.println ("iE1-"+ (++iE1));
            return;
        }
        Node current = root;
        Node prev;
        while (true) {
            //System.out.println ("iE2-"+ (++iE2));
            prev = current;
            if (key < current.key) {
                //System.out.println ("iE3-"+ (++iE3));
                current = current.leftChild;
                if (current == null) {
                    prev.leftChild = newElement;
                    //System.out.println ("iE4-"+(++iE4));
                    return;
                }
            } else {
                current = current.rightChild;
                //System.out.println ("iE5-"+ (++iE5));
                if (current == null) {
                    prev.rightChild = newElement;
                    //System.out.println ("iE6-"+ (++iE6));
                    return;
                }
            }
        }
    }

    public Node findElement (Integer key) {
        int fE1 = 0;
        int fE2 = 0;
        int fE3 = 0;
        int fE4 = 0;
        if (root.key == key) {
            //System.out.println ("fE1-" + (++fE1));
            return root;
        }
        Node current = root;
            while (current.key != key) {
                //System.out.println ("fE2-" + (++fE2));
                if (key < current.key) {
                    //System.out.println ("fE3-" + (++fE3));
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                    //System.out.println ("fE4-" + (++fE4));
                }
                if (current == null) {
                    return null;
                }
            }
        return current;
    }

    public void print (Node startNode) {
        if (startNode != null) {
            print(startNode.leftChild);
            startNode.printNode();
            print(startNode.rightChild);
        }
    }

    public boolean remove (int key) {
       if (key == root.key) {
           Node buf = root;
           root = searchHeir(root);
           root.rightChild = buf.rightChild;
           return true;
       } else {
           Node current = root;
           Node prev;
           while (current.key != key) {
               prev = current;
               if (key < current.key) {
                   current = current.leftChild;
                   if (key == current.key) {
                       if (current.leftChild == null && current.rightChild == null) {
                           prev.leftChild = null;
                       } else if (current.leftChild == null) {
                           prev.leftChild = current.rightChild;
                       } else if (current.rightChild == null) {
                           prev.leftChild = current.leftChild;
                       } else {
                           prev.leftChild = searchHeir(current);
                       }
                       return true;
                   }
               } else {
                   current = current.rightChild;
                   if (key == current.key) {
                       if (current.leftChild == null && current.rightChild == null) {
                           prev.rightChild = null;
                           return true;
                       } else if (current.leftChild == null) {
                           prev.rightChild = current.rightChild;
                       } else if (current.rightChild == null) {
                           prev.rightChild = current.leftChild;
                       } else {
                           prev.rightChild = searchHeir(current);
                       }
                       return true;
                   }
               }
           }
           return false;
       }
    }

    public Node searchHeir (Node el) {
        Node current = el.rightChild;
        if (current.leftChild == null && current.rightChild == null) {
            el.value = current.value;
            el.rightChild = null;
        } else {
            Node prev = current;
            while (current.leftChild != null) {
                prev = current;
                current = current.leftChild;
            }
            if (current.rightChild == null) {
                prev.leftChild = null;
            } else {
                prev.leftChild = current.rightChild;
            }
            el.value = current.value;
        }
        current.leftChild = el.leftChild;
        return current;
    }
}
