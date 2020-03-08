public class RemoveDuplicateLinkList {
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

    void rm_duplicates() {
        Node2 p = root.next;
        Node2 q = root;

        while(p != null)
        {
            if(p.data != q.data)
            {
                q = p;
                p = p.next;
            }
            else
            {
                q.next = p.next;
                p = q.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 5, 8, 8, 8, 10};
        RemoveDuplicateLinkList ob1 = new RemoveDuplicateLinkList();
        ob1.create(a);
        ob1.rm_duplicates();
        ob1.display(ob1.root);
    }
}
