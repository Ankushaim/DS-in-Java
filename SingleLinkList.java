import java.nio.file.ReadOnlyFileSystemException;

class Node {
    int data;
    Node next;
}
/**
* Abdul Bari Data and Algorithm... Here we are not creating root reference and directly creating first node
* unlike other implementation.
* */

public class SingleLinkList {
    Node root = new Node(); // Creating first node in memory and allocating space...

    void create(int[] a, int len) {
        Node temp; Node last; // Temp will create other temp nodes and then we will link them through loop

        // Assigning values to first node..
        root.data = a[0];
        root.next = null;
        // last root will always keep track of last node...
        last = root;

        for(int i = 1; i < len; i++) {
            // assigning memory and data to temp node
            temp = new Node();
            temp.data = a[i];
            temp.next = null;
            // Linking temp node to previous node..
            last.next = temp;
            // Updating last node to newly created node..
            last = temp;
        }

    }

    void display(Node r) {
        while(r != null) {
            System.out.print(r.data+ " ");
            r = r.next;
        }
        System.out.println();
    }

    void R_display(Node r) {
        if ( r != null) {
            // Note: If we call print after function then list will be printed in reverse..
            System.out.print(r.data + " ");
            R_display(r.next);
        }
    }

    int count(Node r) {
        int count = 0;
        while (r != null) {
            count++;
            r = r.next;
        }
        return count;
    }

    int R_count(Node r) {
        if(r == null) {
            return 0;
        }
        return R_count(r.next) + 1;
    }

    int max(Node r) {
        int max = Integer.MIN_VALUE;
        while (r != null)
        {
            if(max < r.data)
                max = r.data;
            r = r.next;
        }
        return max;
    }

    int R_max(Node r) {
        int max = Integer.MIN_VALUE;
        //base case for last call
        if (r == null)
        {
            return max;
        }
        max = max(r.next);
        if (max > r.data)
            return max;
        else
            return r.data;
    }

    /**
     * This is optimized solution for leaner search where the frequent search key will be placed in first
     *  So that next time we can get result in O(1) time....
      */

    Node LSearch(Node p, int key) {
        Node q = null;
        while (p != null)
        {
            if ( p.data == key)
            {
                q.next = p.next;
                p.next = root;
                root = p;
                return p;
            }
            q = p;
            p = p.next;
        }
        return null;
    }

    Node RSearch(Node r, int key) {
        if( r == null)
        {
            return null;
        }
        if (r.data == key)
        {
            return r;
        }
        return RSearch(r.next, key);
    }

    /**
    * This method will not only insert at the beginning of list means at index 0
    * this can also insert at middle of list and end of list..
    * */
    void insert(Node r, int index, int value) {
        if (index < 0 || index > count(r)) {
            return;
        }
        Node temp = new Node();
        temp.data = value;
        temp.next = null;
        if (index == 0) {
            temp.next = root;
            root = temp;
        }
        else
        {
            for (int i = 0; i < index - 1; i++) {
                r = r.next;
            }
            temp.next = r.next;
            r.next = temp;
        }

    }


    public static void main(String[] args) {
        SingleLinkList listObj = new SingleLinkList();
        int[] A = {3,5,7,10,25,8,32,2};
        listObj.create(A, A.length);
        //listObj.display(listObj.root);
        listObj.R_display(listObj.root);
        System.out.println();
        //System.out.println(listObj.count(listObj.root));
        System.out.println(listObj.R_count(listObj.root));
        //System.out.println(listObj.max(listObj.root));
        System.out.println(listObj.R_max(listObj.root));

        Node temp = listObj.RSearch(listObj.root, 8);
        System.out.println(temp.data);

        Node temp1 = listObj.LSearch(listObj.root, 8);
        System.out.println(temp1.data);
        listObj.display(listObj.root);
        listObj.insert(listObj.root, 0, 5);
        listObj.display(listObj.root);


    }



}
