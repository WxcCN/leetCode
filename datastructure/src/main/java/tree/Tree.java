package tree;

import util.BinTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Nova wangxingchen
 * @date 2018/12/28
 */

public class Tree {
    public static void main(String[] args) {
/*   3
    / \
   4   5
  / \   \
 1   2   9
    /
   0
   */
        BinTreeNode<Integer> root = new BinTreeNode<>(3);
        BinTreeNode<Integer> node4 = new BinTreeNode<>(4);
        BinTreeNode<Integer> node5 = new BinTreeNode<>(5);
        BinTreeNode<Integer> node1 = new BinTreeNode<>(1);
        BinTreeNode<Integer> node2 = new BinTreeNode<>(2);
        BinTreeNode<Integer> node0 = new BinTreeNode<>(0);
        BinTreeNode<Integer> node9 = new BinTreeNode<>(9);
        root.left = node4;
        root.right = node5;
        node4.left = node1;
        node4.right = node2;
        node2.left = node0;
        node5.right = node9;

        Tree tree = new Tree();
//        System.out.println("深度：" + tree.getDepth(root));
//        System.out.println("前序：" );
//        tree.preReadDfs(root);
//        System.out.println("后序：" );
//        tree.postReadNoRecusion(root);
        System.out.println("层序：" );
        tree.leverRead(root);
    }

    //前序遍历 递归
    void preReadDfs(BinTreeNode node) {
        if (node==null) return;
        System.out.print(node.data+",");
        preReadDfs(node.left);
        preReadDfs(node.right);
    }

    void postReadNoRecusion(BinTreeNode node) {
        Stack<BinTreeNode> st = new Stack<>();
        BinTreeNode p =node;
        st.push(node);
        while (st.size()!=0) {
            BinTreeNode peek = st.peek();
            if (peek.right == p || peek.left == p) {
                p = st.pop();
                System.out.println(p.data+",");
                continue;
            }
            if (peek.left == null && peek.right == null) {
                p = st.pop();
                System.out.println(p.data+",");
                continue;
            }

            if (peek.right != null) {
                st.push(peek.right);
            }
            if (peek.left != null) {
                st.push(peek.left);
            }
        }
    }

    //层序遍历 队列
    void leverRead(BinTreeNode node) {
        LinkedList<BinTreeNode> list = new LinkedList<BinTreeNode>();
        list.add(node);
        int level = 1;
        while (!list.isEmpty()) {
            int size = list.size();
            while (size-->0) {
                BinTreeNode poll = list.poll();
                System.out.print(poll.data+",");
                if (poll.left!=null) {
                    list.add(poll.left);
                }
                if (poll.right!=null) {
                    list.add(poll.right);
                }
            }
            System.out.println("level"+level++);
        }
    }
    //    求数深start
    public int getDepth(BinTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }

    private int getWeight(BinTreeNode node) {
        return 0;

    }

    // 直径
    int diameter ;
    int getDiameter(BinTreeNode node) {
        diameter = 1;
        getDepth(node);
        return diameter-1;
    }

    int getDiameterHelper(BinTreeNode node) {
        if (node == null) return 0;
        int L = getDiameterHelper(node.left);
        int R = getDiameterHelper(node.right);
        diameter = Math.max(diameter, L+R+1);
        return Math.max(L, R) + 1;
    }

    //直径end


}
