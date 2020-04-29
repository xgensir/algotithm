import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%AD%A6%E4%B9%A0%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95%E7%9A%84%E9%AB%98%E6%95%88%E6%96%B9%E6%B3%95.md
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

/* 基本的 N 叉树节点 */
//或者当作图的遍历算法：图用临接表实现
//N 叉树的遍历又可以扩展为图的遍历，因为图就是好几 N 叉棵树的结合体。你说图是可能出现环的？这个很好办，用个布尔数组 visited 做标记就行了
class NTreeNode {
    int val;
    TreeNode[] children;

    void traverse(TreeNode root) {
        for (TreeNode child : root.children)
            traverse(child)
    }
}
//回溯算法框架（先后序遍历算法）
//https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3%E4%BF%AE%E8%AE%A2%E7%89%88.md
class BackTrace {
    result = []
    void traverse(路径, 选择列表) {
        if (满足结束条件) {
            result.add(路径);
            return;
        }
        for 选择 in 选择列表 {
            result.add(选择);
            backtrack(路径, 选择列表)
            result.remove(选择);
        }
    }
}

//动态规划详解
//https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AF%A6%E8%A7%A3%E8%BF%9B%E9%98%B6.md
1.重叠子问题(可以用DP table记录)   (fib(n-1)和fib(n-2)的计算会有重叠的)
2.最优化子结构      (fib(n-1)和fib(n-2)的值都是最优的,通过最优子结构算出目标值)https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E6%9C%80%E4%BC%98%E5%AD%90%E7%BB%93%E6%9E%84.md
3.状态转移方程(类似数学归纳法)  (n是状态,式子就是状态转移方程)
如斐波那契数列
fib(n) = {
        1; //n ==1 || n==2
        fib(n-1) + fib(n-2)
}
int fib(int N) {
    if (N == 1 || N == 2) return 1;
    return fib(N - 1) + fib(N - 2);
}
