import java.util.Scanner;

class Stack {
    int top = -1;
    int size;
    int[] st;
}

public class StackUsingArray {
    void push(Stack ob, int value) {
        if (ob.top == ob.size - 1)
        {
            System.out.println("Stack Overflow");
        }
        else
        {
            ob.top++;
            ob.st[ob.top] = value;
        }
    }

    void pop(Stack ob) {
        if(ob.top == -1)
        {
            System.out.println("Stack is underflow");
        }
        else
        {
            System.out.println(ob.st[ob.top]);
            ob.top--;
        }
    }

    void peek(Stack ob, int pos) {
        if(ob.top - pos + 1 < 0 || ob.top - pos + 1 > ob.top)
        {
            System.out.println("Invalid position");
        }
        else
        {
            System.out.println(ob.st[ob.top - pos + 1]);
        }
    }

    void stackTop(Stack ob) {
        if(ob.top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println(ob.st[ob.top]);
        }
    }

    void isEmpty(Stack ob) {
        if(ob.top == -1)
        {
            System.out.println("Yes Stack is empty");
        }
        else
        {
            System.out.println("No Stack is not empty");
        }
    }

    void isFull(Stack ob) {
        if(ob.top >= ob.size - 1)
        {
            System.out.println("Yes stack is full");
        }
        else
        {
            System.out.println("No stack is not full");
        }
    }

    void display(Stack ob) {
        if(ob.top != -1)
        {
            for (int i = 0; i <= ob.top; i++) {
                System.out.print(ob.st[i] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack ob1 = new Stack();
        System.out.print("Enter the size of Stack: ");
        Scanner input = new Scanner(System.in);
        ob1.size = input.nextInt();
        ob1.st = new int[ob1.size];

        StackUsingArray ob2 = new StackUsingArray();
        ob2.isEmpty(ob1);

        ob2.push(ob1, 1);
        ob2.push(ob1, 3);
        ob2.push(ob1, 5);
        ob2.push(ob1, 7);
        ob2.push(ob1, 9);

        ob2.display(ob1);
        ob2.isFull(ob1);

        ob2.isEmpty(ob1);
        ob2.pop(ob1);
        ob2.pop(ob1);
        ob2.pop(ob1);
        ob2.isFull(ob1);

        ob2.peek(ob1, 1);
        ob2.peek(ob1, 0);
        ob2.peek(ob1, 2);

        ob2.stackTop(ob1);
    }
}
