public class CircularLinkList {
    NodeMain head = new NodeMain();
    static int flag = 0;

    void create(int[] a) {
        NodeMain last;
        head.data = a[0];
        head.next = head;
        last = head;

        for(int i = 1; i < a.length; i++)
        {
            NodeMain temp = new NodeMain();
            temp.data = a[i];
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    void display() {
        NodeMain p = head;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        }
        while(p != head);
        System.out.println();
    }

    void R_display(NodeMain h) {
        if(h != head || flag == 0)
        {
            flag = 1;
            System.out.print(h.data + " ");
            R_display(h.next);
        }
        /*
        * This will not make any error but if we are using display again and again in our code then flag is static and we will not
        * be able to display list again.
        * */

        flag = 0;
    }

    void insert(int position, int value) {
        NodeMain p = head;
        NodeMain temp = new NodeMain();

        if(position == 0)
        {
            temp.data = value;

            while (p.next != head)
            {
                p = p.next;
            }
            p.next = temp;
            temp.next = head;
            head = temp;
        }
        else
        {
            for(int i = 0; i < position - 1 ; i++)
            {
                p = p.next;
            }
            temp.data = value;
            temp.next = p.next;
            p.next = temp;
        }
    }

    void delete(int position)
    {
        NodeMain p = head;
        NodeMain q = null;
        if(position == 1)
        {
            while(p.next != head)
            {
                p = p.next;
            }
            p.next = head.next;
            head = head.next;
        }
        else
        {
            for(int i = 0; i < position - 1; i++)
            {
                q= p;
                p = p.next;
            }
            q.next = p.next;
            p = null;
        }
    }

    public static void main(String[] args) {
        CircularLinkList ob1= new CircularLinkList();
        int[] a = {3,5,7,9};
        ob1.create(a);
        ob1.display();
        //ob1.R_display(ob1.head);
        ob1.insert(0, 0);
        ob1.display();

        ob1.insert(3, 8);
        ob1.display();

        ob1.delete(1);
        ob1.display();

        ob1.delete(5);
        ob1.display();

        ob1.delete(2);
        ob1.display();
    }
}
