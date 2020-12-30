package Tree_29_12_2020;

public class Main_tree {

    public static void main (String [] args) {

        Tree tree1 = new Tree ();

        tree1.insertElement(6, "Шесть");
        tree1.insertElement(3, "Три");
        tree1.insertElement(1, "Один");
        tree1.insertElement(5, "Пять");
        tree1.insertElement(9, "Девять");
        tree1.insertElement(11, "Одинадцать");
        tree1.insertElement(8, "Восемь");
        tree1.insertElement(7, "Семь");
        tree1.insertElement(12, "Двенадцать");

        tree1.print(tree1.root);
        System.out.println("====================================1=====================================");
        Node p = tree1.root;
        tree1.print(p);
        System.out.println("====================================2====================================");
        Node m = tree1.findElement(3);
        tree1.print(m);
        System.out.println("==================================3=======================================");
        System.out.println(m);
        System.out.println("===================================4======================================");
        try {
            System.out.println(tree1.findElement(13).value);
        } catch (NullPointerException e) {
        System.out.println (" Элемента с таким ключем нет ");
        }
        System.out.println("=================================5========================================");
        try {
        System.out.println(tree1.findElement(12).toString());
        } catch (NullPointerException e) {
            System.out.println (" Элемента с таким ключем нет ");
        }
        System.out.println("=================================6========================================");
        tree1.print(tree1.root);
        System.out.println("=================================7========================================");
        tree1.remove(6);
        tree1.print(tree1.root);
        }
    }
