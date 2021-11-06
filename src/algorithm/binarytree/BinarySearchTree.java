package algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author: lllddd
 * created on: 2021/9/13 22:03
 * description:二分搜索树
 */
public class BinarySearchTree {
    //                                            20
    //                                         /      \
    //                                       12        21
    //                                      /  \         \
    //                                     6    13        27
    //                                    /  \           /   \
    //                                  2     9        29     31
    //                                    \
    //                                     3

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(20));
        tree.insert(new Node(12));
        tree.insert(new Node(21));
        tree.insert(new Node(6));
        tree.insert(new Node(2));
        tree.insert(new Node(27));
        tree.insert(new Node(9));
        tree.insert(new Node(3));
        tree.insert(new Node(31));
        tree.insert(new Node(13));
        tree.insert(new Node(29));

        tree.preOrderTraversal();

        System.out.println();

        tree.midOrderTraversal();

        System.out.println();

        tree.afterOrderTraversal();

        System.out.println();

        tree.breadthFirstSearch();

        System.out.println();

        System.out.println(tree.query(new Node(1)));
    }

    private Node mRoot;

    int mCount;

    public BinarySearchTree() {
        this.mCount = 0;
    }

    /**
     * 获取树中的元素个数
     *
     * @return 树中的元素个数
     */
    public int size() {
        return this.mCount;
    }

    /**
     * 判断树是否为空
     *
     * @return 树是否为空
     */
    public boolean isEmpty() {
        return this.mCount == 0;
    }

    /**
     * 向数中插入一个新的节点
     *
     * @param newNode 新节点
     */
    public void insert(Node newNode) {
        if (newNode == null) {
            return;
        }

        mRoot = __insert(mRoot, newNode);
    }

    private Node __insert(Node root, Node newNode) {
        if (root == null) {
            mCount++;
            return newNode;
        }

        if (newNode.value > root.value) {
            root.right = __insert(root.right, newNode);
        }
        if (newNode.value < root.value) {
            root.left = __insert(root.left, newNode);
        }
        return root;
    }

    /**
     * 查找节点
     *
     * @param target 目标节点
     * @return 是否查到目标节点
     */
    public boolean query(Node target) {
        if (mRoot == null || target == null) {
            return false;
        }

        return __query(mRoot, target);
    }

    private boolean __query(Node mRoot, Node target) {
        if (mRoot == null) {
            return false;
        }

        if (mRoot.value == target.value) {
            return true;
        } else if(mRoot.value > target.value) {
            return __query(mRoot.left, target);
        } else {
            return __query(mRoot.right, target);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal() {
        __preOrderTraversal(mRoot);
    }

    private void __preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print("  " + root.value);
            __preOrderTraversal(root.left);
            __preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     */
    private void midOrderTraversal() {
        __midOrderTraversal(mRoot);
    }

    private void __midOrderTraversal(Node root) {
        if (root != null) {
            __midOrderTraversal(root.left);
            System.out.print("  " + root.value);
            __midOrderTraversal(root.right);
        }
    }

    /**
     * 或许遍历
     */
    private void afterOrderTraversal() {
        __afterOrderTraversal(mRoot);
    }

    private void __afterOrderTraversal(Node root) {
        if (root != null) {
            __afterOrderTraversal(root.left);
            __afterOrderTraversal(root.right);
            System.out.print("  " + root.value);
        }
    }

    /**
     * 广度优先搜索
     */
    public void breadthFirstSearch() {
        if (mRoot == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(mRoot);
        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print("  " + node.value);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 删除值为value的节点并重新组织BST
     */
    public void delete(int value) {
        // TODO: 2021/9/15  
    }
}
