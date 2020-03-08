public class ConcateLinkList {
    Node2 ll1 = new Node2();
    Node2 ll2 = new Node2();
    void create(int[] arr, Node2 root){
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

    void concat() {
        Node2 r = ll1;
        while(r.next != null)
        {
            r = r.next;
        }
        r.next = ll2;
    }



    public static void main(String[] args) {
        int[] a = {3, 5, 5};
        int[] b = {4,0,9};

        ConcateLinkList ob1 = new ConcateLinkList();
        ob1.create(a, ob1.ll1);

        ob1.create(b, ob1.ll2);
        ob1.display(ob1.ll1);
        ob1.display(ob1.ll2);

        ob1.concat();
        ob1.display(ob1.ll1);


    }
}
