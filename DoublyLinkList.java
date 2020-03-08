public class DoublyLinkList {
    DoublyNode root = new DoublyNode();

    void create(int[] a) {
        DoublyNode last;
        root.data = a[0];
        root.previous = root.next = null;
        last = root;

        for (int i = 1; i < a.length; i++) {
            DoublyNode temp = new DoublyNode();
            temp.data = a[i];
            temp.next = last.next;
            temp.previous = last;
            last.next = temp;
            last = temp;
        }
    }

    void display() {
        DoublyNode p = root;
        while(p != null)
        {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    void length() {
        DoublyNode p = root;
        int len = 0;
        while(p != null)
        {
            len++;
            p = p.next;
        }
        System.out.println(len);
    }

    void insert(int position, int value) {
        DoublyNode p = root;
        if(position == 0)
        {
            DoublyNode temp = new DoublyNode();
            temp.data = value;
            temp.previous = null;
            temp.next = p;
            p.previous = temp;
            root = temp;
        }
        else
        {
            DoublyNode temp = new DoublyNode();
            temp.data = value;

            for(int i = 0; i < position - 1; i++)
            {
                p = p.next;
            }
            temp.previous = p;
            temp.next = p.next;
            if(p.next != null)
            {
                p.next.previous = temp;
            }
            p.next = temp;
        }
    }

    void delete(int position) {
        DoublyNode p = root;
        if(position == 1)
        {
            root = p.next;

            if(root != null)
            {
                root.previous = null;
            }
        }
        else
        {
            for(int i = 0; i < position - 1; i++)
            {
                p = p.next;
            }
            p.previous.next = p.next;
            if(p.next != null)
            {
                p.next.previous = p.previous;
            }
        }
    }

    void reverse() {
        DoublyNode p = root;
        while(p != null)
        {
            DoublyNode temp = p.next;
            p.next = p.previous;
            p.previous = temp;
            root = p;
            p = p.previous;
        }

    }

    public static void main(String[] args) {
        int[] a = {3,5,7,9,11};
        DoublyLinkList ob1 = new DoublyLinkList();
        ob1.create(a);
        ob1.display();
        ob1.length();
        ob1.insert(0, 44);
        ob1.display();
        ob1.insert(5, 4);
        ob1.display();
        ob1.insert(7, 55);
        ob1.display();

        ob1.delete(1);
        ob1.display();

        ob1.delete(3);
        ob1.display();

        ob1.reverse();
        ob1.display();
    }
}
