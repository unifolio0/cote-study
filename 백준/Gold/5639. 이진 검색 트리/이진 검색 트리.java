import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int f = Integer.parseInt(br.readLine());
        Node root = new Node(f, null, null);
        while (true) {
            String num = br.readLine();
            if (num == null || num.isEmpty()) {
                break;
            }
            root.insert(Integer.parseInt(num));
        }

        postOrder(root);

        br.close();

        bw.flush();
        bw.close();
    }

    private static void postOrder(Node root) throws IOException {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        bw.write(root.num + "\n");
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int k) {
            if (num > k) {
                if (this.left == null) {
                    this.left = new Node(k, null, null);
                } else {
                    this.left.insert(k);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(k, null, null);
                } else {
                    this.right.insert(k);
                }
            }
        }
    }
}
