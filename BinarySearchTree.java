public class BinarySearchTree // This will create tree node structure..
{
    BinarySearchTree left;
    int value;
    BinarySearchTree right;

    public BinarySearchTree( int value )  // Constructor to initialize data..
    {
        this.left = null;
        this.value = value;
        this.right = null;
    }
}

class Bst{
    BinarySearchTree root = null; // creating root node..

    void insert(int data)
    {
        root = insertRec(root, data);
    }

    BinarySearchTree insertRec(BinarySearchTree r, int data)
    {
        if(r == null) // if root node is null (When Tree is empty)
        {
            r = new BinarySearchTree(data); // This will call cons and initialize data to root..
            return r;
        }
        if(data < r.value) // To check if data need to add to left(As all small data will be added to left)..
        {
            r.left =  insertRec(r.left, data);
        }
        else if(data > r.value) // To check if data need to add to right(As all big data will be added to right)..
        {
            r.right = insertRec(r.right,data);
        }
        return r; // This will return root every time(This is necessary for recursion base cases apart from null condition)..
    }

    void search(int value)
    {
        BinarySearchTree current = root; // Just to ensure we will not damage root
        if(current == null) // To check if Tree is empty
        {
            System.out.println("Tree is empty");
        }
        else
        {
            while(current != null) // Because leaf nodes are always null and leaf nodes are end of tree
            {
                if(current.value == value) // if value matches
                {
                    System.out.println(value);
                    System.out.println("Value is in Tree");
                    break;
                }
                else if(current.value > value) // if value is less then current node
                {
                    current = current.left; // then it must be in left side of tree
                }
                else
                {
                    current = current.right; // else must be in right side of tree
                }
            }
        }
    }

    void deleteKey(int value)
    {
        root =  deleteRec(root, value);
    }

    BinarySearchTree deleteRec(BinarySearchTree current, int v)
    {
        if (current == null) // If tree is empty
        {
            System.out.println("Element not in Tree ");
            return null;
        }

        /*
            This part of code will check both cases where
            1. Leaf node is not having any child or
            2. Any node in tree is having single child(Only one child)
         */
        if(current.value == v) // If we found the value
        {
            /*if (current.left == null && current.right == null)  // This is not necessary
            {
                return null;
            }*/

            if(current.left == null)
            {
                return current.right;
            }
            else
            {
                return current.left;
            }
        }
        if (v < current.value) // To check if data is in left side(As all small data will be in left)..
        {
            current.left = deleteRec(current.left, v);
            return current;
        }
        else if (v > current.value) // To check if data is in right side(As all big data will be in right)..
        {
            current.right = deleteRec(current.right, v);
            return current;
        }
        /*
        * This part will check Third case where node is having two children
        * and we will decide which one will be replaced with the deleted value
        * */
        current.value = minValue(current.right); // This will calculate the min value from the left side of tree..
        current.right = deleteRec(current.right, current.value); // This will remove the min value node from right side..
        return root;
    }

    int minValue(BinarySearchTree temp)
    {
        int min = temp.value;
        while (temp.left != null)
        {
            temp = temp.left;
            min = temp.value;
        }
        return min;
    }

    void preorderRec(BinarySearchTree root) // Preorder (DLR) Traversal
    {
        if (root != null)
        {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void inorderRec(BinarySearchTree root) // Inorder (LDR) Traversal
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    void postorderRec(BinarySearchTree root) // Postorder (LRD) Traversal
    {
        if (root != null)
        {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    int findMin(BinarySearchTree root)
    {
        while (root.left != null)
        {
            root = root.left;
        }
        return root.value;
    }

    int findMax(BinarySearchTree root)
    {
        while (root.right != null)
        {
            root = root.right;
        }
        return root.value;
    }


    public static void main(String[] args) {
        Bst ob1 = new Bst();
        ob1.insert(50);
        ob1.insert(30);
        ob1.insert(20);
        ob1.insert(40);
        ob1.insert(70);
        ob1.insert(60);
        ob1.insert(80);
        ob1.preorderRec(ob1.root);
        System.out.println();
        ob1.inorderRec(ob1.root);
        System.out.println();
        ob1.postorderRec(ob1.root);
        System.out.println();
        System.out.println(ob1.findMin(ob1.root));
        System.out.println(ob1.findMax(ob1.root));

//        System.out.println("");
//        ob1.deleteKey(20);
//        ob1.inorderRec(ob1.root);
//        System.out.println("");
//        ob1.deleteKey(30);
//        ob1.inorderRec(ob1.root);
//        System.out.println("");
    }
}


//    void insert(int data)
//    {
//        BinarySearchTree current = root;
//        BinarySearchTree previous = null;
//        while(current != null)
//        {
//            previous = current;
//            if(current.value >data)
//            {
//                current = current.left;
//            }
//            else if(current.value < data)
//            {
//                current = current.right;
//            }
//            else
//            {
//                System.out.println("Value already in Tree");
//            }
//        }
//        BinarySearchTree temp = new BinarySearchTree();
//        temp.value = data;
//        temp.left = null;
//        temp.right = null;
//        if(root == null)
//        {
//            root = temp;
//        }
//        else
//        {
//            if( previous.value > data)
//            {
//                previous.left = temp;
//            }
//            else
//            {
//                previous.right = temp;
//            }
//        }
//    }