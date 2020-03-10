class Node2 {
    char data;
    Node2 next;
}

public class ParenthesisMatchingDemo2 {
    Node2 root = null;

    void push(char value) {
        Node2 temp = new Node2();
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
            if (c == '(' || c == '{' || c == '[')
                push(c);

            if (c == ')' || c == '}' || c == ']') {
                if (root == null)
                    return false;
                pop();
            }
        }
        return root == null;
    }

    public static void main(String[] args) {
        ParenthesisMatchingDemo2 ob1 = new ParenthesisMatchingDemo2();
        String s = "{([a+b] * [a-d])/e}";
        char[] temp = s.toCharArray();

        boolean check = ob1.isBalanced(temp);

        if (check)
            System.out.println("yes balanced");
        else
            System.out.println("Not balanced");
    }
}
