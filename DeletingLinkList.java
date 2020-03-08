/*
* Here is the program for deleting specific node from link list. For deletion we can raise a request in 2 ways delete first node
* or delete last or any middle node...
* This program also contain method to check if the link list is sorted or not..
* */

class Node2 {
    int data;
    Node2 next;
}

public class DeletingLinkList {
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

    int delete(Node2 r, int position) {
        int x;
        if(r == null)
        {
            return -1;
        }
        else if(position == 1)
        {
            x = r.data;
            root = r.next;
            return x;
        }
        else
        {
            Node2 p = r;
            Node2 q = null;
            for (int i = 0; i < position - 1; i++) {
                q = p;
                p = p.next;
            }
            q.next = p.next;
            x = p.data;
            p = null;
            return x;
        }
    }

    boolean is_sorted() {
        Node2 p = root;
        int min = Integer.MIN_VALUE;
        while(p != null)
        {
            if(p.data < min)
            {
                return false;
            }
            min = p.data;
            p = p.next;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        int[] a = {3,5,7,10,25,32};
        DeletingLinkList ob1 = new DeletingLinkList();
        ob1.create(a);
        ob1.display(ob1.root);

        boolean check = ob1.is_sorted();
        if(check == true)
            System.out.println("Sorted");
        else
            System.out.println("Not sorted");

        int del_value;
        del_value = ob1.delete(ob1.root, 4);
        System.out.println(del_value);
        ob1.display(ob1.root);
        del_value = ob1.delete(ob1.root, 1);
        System.out.println(del_value);
        ob1.display(ob1.root);
        del_value = ob1.delete(ob1.root, 1);
        System.out.println(del_value);
        ob1.display(ob1.root);
        
    }
}
