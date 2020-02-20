class Node1 {
    int data;
    Node1 next;
}

public class SortedSingleLL {
    Node1 root;

    void display(Node1 r) {
        while(r != null) {
            System.out.print(r.data+ " ");
            r = r.next;
        }
        System.out.println("");
    }

    /**
     * This method will create sorted list from root..
     * In Java, our while condition is throwing exception as we are checking p.data which will be null at last
     */

    void sortedInsert(Node1 p, int value) {
        Node1 temp = new Node1();
        Node1 q = null;
        temp.data = value;
        temp.next = null;
        if (root == null) {
            root = new Node1();
            root = temp;
        }
        else {
            // while condition is throwing exception as we are checking p.data which will be null at last..
            try{
                while (p.data < value && p != null) {
                    q = p;
                    p = p.next;
                }
            }
            catch (Exception e){}
            // If we have only one element in list and value is less then element of list
            if (p == root)
            {
                temp.next = root;
                root = temp;
            }
            // Else simply value will be added
            else {
                temp.next = q.next;
                q.next = temp;
            }

        }
    }

    public static void main(String[] args) {

        SortedSingleLL ob1 = new SortedSingleLL();
        ob1.sortedInsert(ob1.root, 10);
        ob1.display(ob1.root);
        ob1.sortedInsert(ob1.root, 50);
        ob1.display(ob1.root);
        ob1.sortedInsert(ob1.root, 30);
        ob1.display(ob1.root);
        ob1.sortedInsert(ob1.root, 40);
        ob1.display(ob1.root);
        ob1.sortedInsert(ob1.root, 20);
        ob1.display(ob1.root);
        ob1.sortedInsert(ob1.root, 5);
        ob1.display(ob1.root);


    }

}
