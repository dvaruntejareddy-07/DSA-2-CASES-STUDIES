class Node {
    int id, height;
    Node left, right;

    Node(int id) {
        this.id = id;
        height = 1;
    }
}

public class CO1_AVL {
    Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int id) {
        if (node == null)
            return new Node(id);

        if (id < node.id)
            node.left = insert(node.left, id);
        else if (id > node.id)
            node.right = insert(node.right, id);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && id < node.left.id)
            return rightRotate(node);

        if (balance < -1 && id > node.right.id)
            return leftRotate(node);

        if (balance > 1 && id > node.left.id) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && id < node.right.id) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.id + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        CO1_AVL tree = new CO1_AVL();

        tree.root = tree.insert(tree.root, 101);
        tree.root = tree.insert(tree.root, 105);
        tree.root = tree.insert(tree.root, 103);
        tree.root = tree.insert(tree.root, 110);

        System.out.println("Incident IDs:");
        tree.inorder(tree.root);
    }
}