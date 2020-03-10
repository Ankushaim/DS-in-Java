class Node1{
    char data;
    Node1 next;
}

public class ParenthesisMatching {
    Node1 root = null;
    void push(char value) {
        Node1 temp = new Node1();
        if (root == null)
        {
            temp.data = value;
            temp.next = null;
            root = temp;
        }
        else
        {
            temp.data = value;
            temp.next = root;
            root = temp;

        }
    }

    void pop() {
        if(root != null)
        {
            root = root.next;
        }

    }

    boolean isBalanced(char[] temp) {
        for (char c : temp) {
            if (c == '(')
                push(c);

            if (c == ')') {
                if (root == null)
                    return false;
                pop();
            }
        }
        return root == null;
    }

    public static void main(String[] args) {
        ParenthesisMatchingDemo2 ob1 = new ParenthesisMatchingDemo2();
        String s = "((a+b)*(c-d))";
        char[] temp = s.toCharArray();

        boolean check = ob1.isBalanced(temp);

        if (check)
            System.out.println("yes balanced");
        else
            System.out.println("Not balanced");


    }
}
