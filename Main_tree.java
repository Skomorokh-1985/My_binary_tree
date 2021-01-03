package Tree_29_12_2020;

public class Main_tree {

    public static void main (String [] args) {

        Tree tree1 = new Tree ();

        tree1.insertElement(50, "40");                  // для нормальной визуализации в методе visualizationTree() целесообразно вводить двузначные значения ключей
        tree1.insertElement(30, "20");
        tree1.insertElement(70, "60");
        tree1.insertElement(20, "10");
        tree1.insertElement(40, "70");
        tree1.insertElement(60, "50");
        tree1.insertElement(80, "80");
        tree1.visualizationTree();

        tree1.insertElement(15, "15");
        tree1.insertElement(90, "90");
        tree1.insertElement(44, "44");
        tree1.insertElement(55, "55");
        tree1.visualizationTree();

        tree1.insertElement(46, "46");
        tree1.insertElement(54, "54");
        tree1.insertElement(16, "16");
        tree1.insertElement(17, "17");

        tree1.visualizationTree();

        tree1.insertElement(45, "45");
        tree1.insertElement(47, "47");
        tree1.insertElement(53, "53");
        tree1.insertElement(61, "61");
        tree1.insertElement(62, "62");
        tree1.insertElement(63, "63");
        tree1.insertElement(79, "79");
        tree1.insertElement(78, "78");
        tree1.insertElement(77, "77");
        tree1.visualizationTree();

        tree1.remove(60);
        tree1.remove(30);
        tree1.visualizationTree();

        /*tree1.remove(16);
        tree1.remove(17);
        tree1.visualizationTree();

        tree1.remove(15);
        tree1.visualizationTree();

        tree1.remove(18);
        tree1.visualizationTree();

        tree1.remove(19);
        tree1.visualizationTree();

        tree1.remove(20);
        tree1.visualizationTree();

        tree1.remove(21);
        tree1.visualizationTree();

        tree1.remove(13);
        tree1.visualizationTree();

        tree1.remove(14);
        tree1.visualizationTree();

        tree1.remove(11);
        tree1.visualizationTree();*/

        /*tree1.print(tree1.root);
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
        tree1.print(tree1.root);*/

        }
    }
