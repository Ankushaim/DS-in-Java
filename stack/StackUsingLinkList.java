import java.util.Scanner;

class Node{
    int data;
    Node next;
}

class Stack_link {
    Node root = null;
}

public class StackUsingLinkList {

    void push(Stack_link sl, int value) {
        Node temp = new Node();
        if(temp == null)
            System.out.println("Heap is full can not create new object");

        if(sl.root == null) {
            temp.data = value;
            temp.next = null;
            sl.root = temp;
        }
        else {
            temp.data = value;
            temp.next = sl.root;
            sl.root = temp;
        }
    }

    void pop(Stack_link sl) {
        if(sl.root == null)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println(sl.root.data);
            sl.root = sl.root.next;
        }
    }

    void peek(Stack_link sl, int position) {
        if(sl.root == null)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            Node p = sl.root;
            for (int i = 0; i < position - 1; i++) {
                p = p.next;
            }
            if(p == null || position == 0)
                System.out.println("invalid position");
            else
                System.out.println(p.data);
        }
    }

    void stackTop(Stack_link sl) {
        if(sl.root != null)
            System.out.println(sl.root.data);
        else
            System.out.println("Stack is empty");

    }

    void isEmpty(Stack_link sl) {
        if(sl.root == null)
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is Not empty");
    }

    void display(Stack_link sl) {
        Node p = sl.root;
        while(p != null)
        {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_link ob1 = new Stack_link();
        StackUsingLinkList ob2 = new StackUsingLinkList();

        ob2.isEmpty(ob1);

        ob2.push(ob1, 1);
        ob2.push(ob1, 3);
        ob2.push(ob1, 5);
        ob2.push(ob1, 7);
        ob2.push(ob1, 9);

        ob2.display(ob1);
        ob2.isEmpty(ob1);

        ob2.pop(ob1);
        ob2.pop(ob1);
        ob2.pop(ob1);

        ob2.peek(ob1, 1);
        ob2.peek(ob1, 0);
        ob2.peek(ob1, 2);

        ob2.stackTop(ob1);
    }
}
