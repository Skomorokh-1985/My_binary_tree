package Tree_29_12_2020;

import java.util.ArrayList;

public class Tree {

    public Node root;
    public static int size = 0;

    public Tree() {
    }

    public void insertElement(Integer key, String value) {
        Node newElement = new Node();
        newElement.key = key;
        newElement.value = value;

        if (root == null) {              //Если дерево пустое - вставляемый элемент становится корнем - root
            root = newElement;
            return;                      //выход из метода
        }
        Node current = root;             //текущий элемент присваивается root
        Node prev;                       //создаем элемент "предыдущий" - prev
        while (true) {                   //цикл, прерыввющийся изнутри (словом - return)
            if (key < current.key) {                              //если ключ вставляемого элемента меньше текущего (current)
                prev = current;                                   // тогда двигаемся влево и если после перехода current
                current = current.leftChild;                      // на место его левого потомка
                if (current == null) {                            // он равен null
                    prev.leftChild = newElement;                  //тогда новый элемент становится левым потомком prev
                    return;
                }
            } else {                                              //если ключ вставляемого элемента больше текущего (current)
                prev = current;                                   // тогда двигаемся вправо и если после перехода current
                current = current.rightChild;                     // на место его правого потомка
                if (current == null) {                            // он равен null
                    prev.rightChild = newElement;                 //тогда новый элемент становится правым потомком prev
                    return;
                }
            }
        }
    }

    public Node findElement(Integer key) {
        if (root.key == key) {            // если ключ искомого элемента равен ключу корня, взвращаем корень (root)
            return root;
        }
        Node current = root;              // если key != root.key продолжаем - текущему (current) присваиваем значение root
        while (current.key != key) {      // цикл поиска - пока key запроса не равен ключу текущего (current)
            if (key < current.key) {                             // если ключ искомого < текущего - движение влево
                current = current.leftChild;
            } else {                                             // иначе - движение вправо
                current = current.rightChild;
            }
            if (current == null) {                               //если необходимо искать за элементом null, соответсвенно
                return null;                                     //и искомого не будет - возвращаем null
            }
        }
        return current;                   // когда цикл while завершится - значит было совпадение key и current.key
    }                                     // соответственно - возвращаем current

    public void print(Node startNode) {   // метод последовательного вывода элементов от заданного узла (startNode)
        if (startNode != null) {
            print(startNode.leftChild);   // рекурсивный вывод сначала левого потомка
            startNode.printNode();
            print(startNode.rightChild);  // потом правого потомка
        }
    }

    public boolean remove(int key) {      //key - ключ удаляемого элемента
        try {                             // ловим ошибку NullPointerException, если пытаемся удалить несуществующий элемент
            if (key == root.key) {                             // если key = root.key, тогда проверяем следующие варианты
                if (root.leftChild == null && root.rightChild == null) {        // если у рут нету потомков, просто удаляем рут
                    root = null;
                } else if (root.leftChild == null) {                            // если нету левого потомка, то правый потомок корня
                    root = root.rightChild;                                     // становится корнем
                } else if (root.rightChild == null) {                           // если нету правого потомка, то левый потомок корня
                    root = root.leftChild;                                      // становится корнем
                } else {                                                        // в остальных случаях (если есть оба потомка)
                    root = searchHeir(root);                                    // корню присчаиваем значение наследника корня
                }
                return true;                                  // после чего возвращаем true (можно было и void)
            } else {                                          // если key != root.key - тогда следующее
                Node current = root;                                            // присваиваем текущему элементу root
                Node prev;                                                      // создаем предыдущий элемент - prev (для root - пока нету)
                while (current.key != key) {                                    // цикл пока не совпадет ключ искомого с ключем текущего (current)
                    prev = current;                                             // предыдущему prev присваиваем значение current
                    if (key < current.key) {                                            // если key < current.key
                        current = current.leftChild;                                    // двигаемся влево - текущему элементу присваивается значение его левого потомка
                        if (key == current.key) {                                             // если ключ совпал:
                            if (current.leftChild == null && current.rightChild == null) {         // 1) если у текущего нет потомков, тогда просто
                                prev.leftChild = null;                                             //    левому потомку предыдущего (prev) присваивается null
                            } else if (current.leftChild == null) {                                // 2) если у текущего нет левого потомка, тогда
                                prev.leftChild = current.rightChild;                               //     левому потомку предыдущего присваивается значение правого потомка текущего
                            } else if (current.rightChild == null) {                               // 3) если у текущего нет правого потомка, тогда
                                prev.leftChild = current.leftChild;                                //    левому потомку предыдущего присваивается значение левого потомка текущего
                            } else {                                                               // 4) если у текущего (current) есть оба потомка
                                prev.leftChild = searchHeir(current);                              //    левому потомку предыдущего присваивается значение потомка текущего
                            }                                                                      //    (вызывается метод, который ищет и возвращает потомка)
                            return true;
                        }
                    } else {                                                             // иначе
                        current = current.rightChild;                                    // двигаемся вправо - текущему элементу присваивается значение его правого потомка
                        if (key == current.key) {                                                  // дальнейшие
                            if (current.leftChild == null && current.rightChild == null) {         // действия
                                prev.rightChild = null;                                            // аналогичны (действиям при движении влево)
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
        } catch (NullPointerException ex) {                                            // Если пытаемся удалить несуществующий элемент
            System.out.println(" В дереве нет элемента с таким ключем! ");
            return false;
        }
    }

    public Node searchHeir (Node elem) {        // метод поиска и возврата потомка элемента, указанного в аргументе метода (далее - elem)
        Node current = elem.rightChild;         // т.к. метод вызывается если есть оба потомка удаляемого элемента, то сразу текущему присваиваем значение правого потомка elem
        if (current.leftChild == null) {                   // если у current нет левых потомков (потом мы его вернем как наследника, при этом его правый потомок сохранится(в т.ч. null))
        current.leftChild = elem.leftChild;                         // то достаточно присвоить данному возвращаемому наследнику (current) левый потомок от удаляемого elem
        } else {                                           // иначе
            Node prev = current;                                    // присваиваем предыдущему prev - current
            while (current.leftChild != null) {                     // пока возможно движение влево (у текущего есть левый наследник)
                prev = current;                                           // двигаем левее prev (на место current)
                current = current.leftChild;                              // а current двигаем на место leftChild
            }
            if (current.rightChild != null) {             // если у самого последнего левого элемента есть правый наследник, т.к. сам каррент будет перемещен на место удаляемого элемента,
                prev.leftChild = current.rightChild;                // то левому наследнику предыдущего (prev) присваивается значение правого наледника current (а current в данном месте выпадет из цепи)
            } else {                                      // иначе (если у самого последнего левого элемента нет правого наследника)
                prev.leftChild = null;                              // то левому наследнику предыдущего (prev) просто присваивается значение null
            }
            current.rightChild = elem.rightChild;
            current.leftChild = elem.leftChild;
        }
        return current;
    }

    public void visualizationTree () {                  // метод корректно работает до 5 уровня дерева (начиная с 0 (нулевого), в принципе влезло бы и до 6)
        try {                                           //ловим ошибку StackOverflowError
            System.out.println("\n\n--------------------------------------------------------------------------------------------");

            ArrayList<Node> myAL = new ArrayList<>();      // создаем новый АррайЛист типа Node, в который последовательно будем добавлять элементы каждого уровня дерева
            if (root != null) {                            // отдельно прописали вывод ключа корня в начале дерева (в первом уровне)
                myAL.add(root);                            // в середине по горизонтали предполагаемого пространства вывода всего дерева
                System.out.print("                                            ");
                System.out.print(myAL.get(0).key);
                System.out.print("                                            ");
                System.out.println("\n");
            }

            int k = 0;                                  // номер уровня дерева (корень - нулевой уровень)
            int schet = 1;                              //для фиксирования существующих элементов дерева, переданных в АррайЛист с реальным значением (уже корень добавили, значит - 1)

            while (true) {                              // цикл, который прерывается изнутри
                for (int l = ((int) Math.pow(2, k) - 1); l <= ((int) Math.pow(2, k + 1) - 2); l++) { //для послед. ввода уровней дерева в лист: 1ур. - эл. №№1,2  |  2.ур. - 3,4,5,6 - и т.д.
                    if (myAL.get(l) != null) {                              // т.е. сначала l = 0, и проверяется, чтобы сам элемент не был null
                        if (myAL.get(l).leftChild != null) {                     //если левый потомок элемента myAL.get(l) - (в начала это myAL.get(0) - т.е. root
                            myAL.add(myAL.get(l).leftChild);                     // то следующием элементом добавляется его левый наследник (или null)
                            schet++;
                        } else {
                            myAL.add(null);
                        }
                        if (myAL.get(l).rightChild != null) {
                            myAL.add(myAL.get(l).rightChild);                    // потом следующием элементом добавляется его правый наследник (или null)
                            schet++;                                             // так последовательно добавились элементы первого уровня №1 И №2
                        } else {
                            myAL.add(null);
                        }
                    } else {                        // т.к. передаваемые в Лист элементы связаны с узлом-предшественником, то если предшественник был равен null
                        myAL.add(null);             // то как элементы Листа следующего уровня (которые должны были быть левым и правым потомком предыдущего) добавляется null и null
                        myAL.add(null);             // т.е. всеравно два элемента ложатся каждый раз в лист (потом null отображается как "  "
                    }
                }
                k++;                                // пересчелкиваем уровень
                if (schet >= size(root)) {          // закидываем элементы дерева в АррайЛист, до тех пор, пока счетчик не достигнет реального размера дерева
                    break;
                }
            }

            k = 0;                                  // для вывода АррайЛиста по уровням обнуляем счетчик уровня
            schet = 1;                              // и счетчик реальных элементов дерева, переданных в АррайЛист
            String m;                               // переменная - расстояние между элементами при выводе в консоль
            int n = 2;                              // Т.к. корень вывели в консоль ранее, то начинаем с вывода уровня с двумя элементами (1-2,   3-6, 7-14 и т.д.)
                                                    // k - счетчик уровней, n - счетчик элементов в выводимом уровне

            M2:    // ставим метку (label) для выхода из нужного цикла (когда будут выведены все элементы дерева - по счетчику schet
            {
                while (true) {                      // по мере увеличения уровня дерева (уровня вывода) расстояние между элементами уменьшается ≈ в 2 раза
                    switch (n) {
                        case 2:
                            m = "                       ";
                            break;
                        case 4:
                            m = "           ";
                            break;
                        case 8:
                            m = "     ";
                            break;
                        case 16:
                            m = "  ";
                            break;
                        case 32:
                            m = " ";
                            break;
                        default:
                            m = "GGGGGG";
                            break;
                    }
                    for (int p = ((int) Math.pow(2, k + 1) - 1); p <= ((int) Math.pow(2, k + 2) - 2); p++) {   // выводит по уровням: 1-2, потом 3-6, потом 7-14 и т.д.
                        if (n < 32) {                      // различие при n<32 и n=32 - вначале переменная типа String m выводится до и после элемента, а если n=32 - только после
                            System.out.print(m);           // подходя к выводу элемента сначала выводится заложенное пустое расстояние - m
                            if (myAL.get(p) != null) {     //потом выводится сам элемент (его ключ)
                                System.out.print(myAL.get(p).key);
                                schet++;
                            } else {
                                System.out.print("  ");     // если элемент = null, то выводится "  " - для чего для корректной визуализации целесообразно вводить двузначеные ключи
                            }

                            System.out.print(m);            // и опять выводится заложенное пустое основание - m
                            if (schet >= size(root)) {                   // если все элементы выведены
                                break M2;                                // выходим сразу из цикла while (с помощью метки)
                            }
                        } else if (n == 32) {                             // если n=32,все тоже самое, только расстояние между элементами - переменная String ь
                            if (myAL.get(p) != null) {                    // выводится только один раз после самого элемента (так ровно выводится последний уровень)
                                System.out.print(myAL.get(p).key);
                                schet++;
                            } else {
                                System.out.print("  ");
                            }

                            System.out.print(m);
                            if (schet >= size(root)) {
                                break M2;
                            }
                        } else {                     //если n>32 - дальнейшая визуализация не предусмотрена
                            System.out.println(" Дальнейшая визуализация невозможна. Измените структуру дерева.");
                            return;
                        }
                    }
                    n *= 2;                             //счетчик элементов в каждом уровне
                    k++;                                //счетчик уровней
                    System.out.println("\n");
                }
            }
            System.out.println("\n--------------------------------------------------------------------------------------------");
        } catch (IndexOutOfBoundsException e) {                                      //если поймали ошибку
            System.out.println ("     В дереве нету элементов!    ");
            System.out.println("--------------------------------------------------------------------------------------------");
        }
    }

    public int size (Node startNode) {
        int m = size;                                    //если последний size сохранился больше 0 - то просто обновим size
       try {
           if (startNode != null) {
               size(startNode.leftChild);
               size++;
               size(startNode.rightChild);
           }
    } catch (StackOverflowError e) {
       }
        return size - m;
    }



}
