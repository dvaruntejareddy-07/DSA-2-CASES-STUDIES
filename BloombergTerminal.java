class Node {
    String symbol;
    Node left, right;

    Node(String symbol) {
        this.symbol = symbol;
        left = right = null;
    }
}

public class BloombergTerminal {

    // Build Balanced BST from sorted array
    static Node buildBalancedBST(String[] symbols, int start, int end) {

        if (start > end)
            return null;

        int mid = (start + end) / 2;

        Node root = new Node(symbols[mid]);

        root.left = buildBalancedBST(symbols, start, mid - 1);
        root.right = buildBalancedBST(symbols, mid + 1, end);

        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.symbol + " ");
            inorder(root.right);
        }
    }

    // Search Symbol
    static boolean search(Node root, String target) {

        if (root == null)
            return false;

        System.out.println("Visiting Node: " + root.symbol);

        int cmp = target.compareTo(root.symbol);

        if (cmp == 0)
            return true;

        if (cmp < 0) {
            System.out.println("Moving Left");
            return search(root.left, target);
        } else {
            System.out.println("Moving Right");
            return search(root.right, target);
        }
    }

    // Calculate Height
    static int height(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        String[] symbols = {
                "AAPL", "ADBE", "AMZN", "BABA",
                "BKNG", "COST", "GOOGL", "JPM",
                "META", "MSFT", "NVDA", "ORCL", "TSLA"
        };

        System.out.println("Loading ticker symbols...\n");

        for (String s : symbols) {
            System.out.println("Loaded: " + s);
        }

        System.out.println("\nBuilding Balanced BST...");

        Node root = buildBalancedBST(symbols, 0, symbols.length - 1);

        System.out.println("Balanced BST Created Successfully!");

        System.out.println("\nInorder Traversal:");
        inorder(root);

        System.out.println("\n\nSearching for ticker: NVDA\n");

        boolean found = search(root, "NVDA");

        if (found)
            System.out.println("\nNVDA Found!");
        else
            System.out.println("\nTicker Not Found!");

        System.out.println("\nTree Height: " + height(root));
    }
}