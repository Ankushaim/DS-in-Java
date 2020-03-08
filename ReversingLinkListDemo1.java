public class ReversingLinkListDemo1 {
    Node2 root = new Node2();

    void create(int[] arr){
        Node2 temp;
        Node2 last;
        root.data = arr[0];
        root.next = null;
        last = root;

        for (int i = 1; i < arr.length; i++) {
            temp = new Node2();
            temp.data = arr[i];
            temp.next = null;
            last.next = temp;
            last = temp;
        }
    }

    void display(Node2 r) {
        while(r != null)
        {
            System.out.print(r.data + " ");
            r = r.next;
        }
        System.out.println();
    }

    int count() {
        Node2 p = root;
        int count = 0;
        while (p != null)
        {
            count++;
            p = p.next;
        }
        return count;
    }

    void reverse() {
        Node2 p = root;
        int i = 0;
        int[] temp = new int[count()];
        while(p != null)
        {
            temp[i++] = p.data;
            p = p.next;
        }
        p = root;
        i--;

        while(p != null)
        {
            p.data = temp[i--];
            p = p.next;
        }
    }

    void reverse_sliding_pointers() {
        Node2 p = root;
        Node2 q = null;
        Node2 r = null;

        while(p != null)
        {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        root = q;
    }

//    void reverse_recursion(Node2 q, Node2 p) {
//        if(p != null)
//        {
//            reverse_recursion(p, p.next);
//            p.next = q;
//        }
//        else
//        {
//            root = q;
//        }
//    }


    public static void main(String[] args) {
        int[] a = {3, 5, 5};
        ReversingLinkListDemo1 ob1 = new ReversingLinkListDemo1();
        ob1.create(a);
        ob1.display(ob1.root);

        ob1.reverse();
        ob1.display(ob1.root);

        ob1.reverse_sliding_pointers();
        ob1.display(ob1.root);

//        Node2 r = ob1.root;
//        ob1.reverse_recursion(ob1.root, r);
//        ob1.display(ob1.root);
    }
}

