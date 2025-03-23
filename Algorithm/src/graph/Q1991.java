package graph;

import java.util.Scanner;

/**
 * 트리 순회
 *
 * 이진 트리를 입력받아
 * 전위 순회(preorder traversal),
 * 중위 순회(inorder traversal),
 * 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 */
public class Q1991 {

    static int N;
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            char root, left, right;
            root = sc.next().charAt(0);
            left = sc.next().charAt(0);
            right = sc.next().charAt(0);

            int rootIndex = root - 'A';

            if (left != '.') {
                tree[rootIndex][0] = left - 'A';
            } else {
                tree[rootIndex][0] = -1;
            }
            if (right != '.')  {
                tree[rootIndex][1] = right - 'A';
            } else {
                tree[rootIndex][1] = -1;
            }
        }

        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        sb.append('\n');

        System.out.println(sb);
    }

    static void preorder(int node) {
        if (node == -1) return;
        sb.append((char)(node + 'A'));
        preorder(tree[node][0]);
        preorder(tree[node][1]);
    }

    static void inorder(int node) {
        if (node == -1) return;
        inorder(tree[node][0]);
        sb.append((char)(node + 'A'));
        inorder(tree[node][1]);
    }

    static void postorder(int node) {
        if (node == -1) return;
        postorder(tree[node][0]);
        postorder(tree[node][1]);
        sb.append((char)(node + 'A'));
    }

}
