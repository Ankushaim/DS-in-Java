public class MergingLinkList {

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

    void merge() {
        Node2 first = ll1; Node2 second = ll2; Node2 main; Node2 last;
        if(first.data < second.data)
        {
            main = last = first;
            first = first.next;
            main.next = null;
        }
        else
        {
            main = last = second;
            second = second.next;
            main.next = null;
        }

        while (first != null && second != null)
        {
            if(first.data < second.data)
            {
                last.next = first;
                last = first;
                first = first.next;
                last.next = null;
            }
            else
            {
                last.next = second;
                last = second;
                second = second.next;
                last.next = null;
            }
        }

        if(first != null)
        {
            last.next = first;
        }
        if(second != null)
        {
            last.next = second;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 7};
        int[] b = {4, 6, 10};

        MergingLinkList ob1 = new MergingLinkList();
        ob1.create(a, ob1.ll1);

        ob1.create(b, ob1.ll2);
        ob1.display(ob1.ll1);
        ob1.display(ob1.ll2);

        ob1.merge();
        ob1.display(ob1.ll1);
    }
}
