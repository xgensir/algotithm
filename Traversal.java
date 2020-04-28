import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    class Solution {

    }
}

class ListNode {
    int val;
    ListNode(int x) {
        val = x;
    }
    ListNode next;

    //链表非递归遍历
    public void traverseNonRecursive(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            //operate(curr);
            curr = curr.next;
        }
    }

    //链表递归遍历
    public void traverseRecursive(ListNode head) {
        if (head == null) {
            return;
        }
        //operate(head);
        traverseRecursive(head.next);

    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    //二叉树递归遍历
    public void traverseRecursive(TreeNode head) {
        //operate(head); 先序遍历
        traverseRecursive(head.left);
        //operate(head); 中序遍历
        traverseRecursive(head.right);
        //operate(head); 后序遍历
    }

    //二叉树非递归先序遍历
    public void preTraverseNonRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode curr = head;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (curr != null || treeNodeStack.size() > 0) {
            while (curr != null) {
                treeNodeStack.push(curr);
                //operate(treeNodeStack.peek());
                curr = curr.left;
            }
            if (treeNodeStack.size() > 0) {
                curr = treeNodeStack.pop().right;
            }
        }
    }

    //二叉树非递归中序遍历
    public void midTraverseNonRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode curr = head;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (curr != null || treeNodeStack.size() > 0) {
            while (curr != null) {
                treeNodeStack.push(curr);
                curr = curr.left;
            }
            if (treeNodeStack.size() > 0) {
                //operate(treeNodeStack.peek());
                curr = treeNodeStack.pop().right;
            }
        }
    }

    //二叉树非递归后序遍历
    public void afterTraverseNonRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode curr = head;
        TreeNode last = null;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (curr != null) {
            treeNodeStack.push(curr);
            curr = curr.left;
        }
        while (treeNodeStack.size() > 0) {
            curr = treeNodeStack.peek();
            if (curr.right == null || curr.right == last) {
                //operate(treeNodeStack.peek());
                last = treeNodeStack.pop();
            } else {
                curr = curr.right;
                while (curr != null) {
                    treeNodeStack.push(curr);
                    curr = curr.left;
                }
            }
        }
    }
}
