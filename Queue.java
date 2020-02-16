import java.util.*;
public class Queue {
    int front, rear, size;
    String[] str = new String[3];


    public Queue(int front, int size, int rear) {
        this.front = front;
        this.size = size;
        this.rear = rear;
    }

    void enqueue(String s)
    {
        if (isEmpty())
        {
            //If queue is empty..
            front = rear = 0;
            str[rear] = s;
        }
        else if (isFull())
        {
            // If queue is full
            System.out.println("Queue is Full...");
        }
        else
        {
            // If queue is not empty and full
            rear = (rear + 1) % str.length;
            str[rear] = s;
        }
    }

    void dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty..");
        }
        else if(front == rear)
        {
            // Only One element in queue
            System.out.println(str[rear]);
            //Setting it to initial point where no value in queue
            front = rear = -1;
        }
        else
        {
            System.out.println(str[front]);
            //Increasing front
            front = (front + 1) % str.length;
        }

    }

    void traverse()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty..");
        }
        else
        {
            int i = front;
            while(i != rear)
            {
                System.out.print(str[i]);
                i = (i + 1) % str.length;
            }
            // to print last element remaining
            System.out.print(str[rear]);
            System.out.println("");
        }
    }

    boolean isFull()
    {
        if((rear + 1) % str.length == front)
        {
            return true;
        }
        return false;
    }

    boolean isEmpty()
    {
        if (front == -1 && rear == -1)
        {
            return true;
        }
        return false;
    }
}


class Test{
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Queue ob1 = new Queue(-1,0, -1);
        int length = ob1.str.length;
        Scanner input = new Scanner(System.in);
        int choice;

        while(true)
        {
            System.out.println("1: To Insert emelemt ");
            System.out.println("2: To Delete element");
            System.out.println("3: To display elements");
            System.out.println("4: To Quit..");

            System.out.print("Choice: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Give me string: ");
                    String s = input.next();
                    ob1.enqueue(s);
                    break;
                case 2:
                    ob1.dequeue();
                    break;
                case 3:
                    ob1.traverse();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input try again..");
            }
        }


    }
}
