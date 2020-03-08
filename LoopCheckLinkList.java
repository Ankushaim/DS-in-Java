public class LoopCheckLinkList {

    Node2 ll1 = new Node2();
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

    boolean check()
    {
        Node2 p = ll1;
        Node2 q = ll1;

        do {
            p = p.next;
            q = q.next;
            if(q != null)
            {
                q= q.next;
            }
        }
        while (p != null && q != null &&  p != q);

        if(p == q)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        Node2 t1; Node2 t2;

        LoopCheckLinkList ob1 = new LoopCheckLinkList();
        ob1.create(a, ob1.ll1);

        // To create loop in link list
        t1 = ob1.ll1.next.next;
        t2 = ob1.ll1.next.next.next.next;
        t2.next = t1;

        boolean t = ob1.check();
        if (t == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
