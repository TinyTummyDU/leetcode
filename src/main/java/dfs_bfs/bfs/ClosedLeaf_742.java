package dfs_bfs.bfs;

import java.util.*;

/**
 * @ClassName: ClosedLeaf_742
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2021/11/21 11:00 下午
 * @Version 1.0
 */
public class ClosedLeaf_742 {


//    这是一道非常典型的题目，需要把树转成图，让我们来看看是怎么做的。
//
//    首先题意给了一棵树，这棵树里的每一个节点的值都不相同，问值为K的节点的最近的叶子节点是哪一个。
//
//    如果从root开始遍历，直接bfs，就能找到最近距离的叶子节点，因为现在值为K的几点不一定是root节点，所以需要先将树转化为无权无向图。
//
//    代码中要注意两点，一个是图的建立，这里用了个邻接表；二个是在判断叶子节点时的判断手法，用的是当前节点的邻居列表的长度如果小于等于1，就是叶子节点。


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

//    给定一个 每个结点的值互不相同 的二叉树，和一个目标值 k，找出树中与目标值 k 最近的叶结点。
//
//    这里，与叶结点 最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少。
//    而且，当一个结点没有孩子结点时称其为叶结点。
//
//    在下面的例子中，输入的树以逐行的平铺形式表示。
//    实际上的有根树 root 将以TreeNode对象的形式给出。
//
    public int findClosedLeaf(TreeNode root, int k){
        // 转化为图，然后从值为k的开始BFS，当到达叶子节点的时候，返回叶子节点的值
        if (root == null) {
            return 0;
        }
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        transToGraph(root, map, null);

        transToGraph(root,map,null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //先找到目标节点
        for (TreeNode node : map.keySet()) {
            // node == null，会有这种情况，因为一开始root的父亲是null，也被加入到了map里面，但是后面其实没用了
            if (node != null && node.val == k) {
                queue.add(node);
                visited.add(node.val);
            }
        }

        //层序遍历，旋转一下，现在你的target k节点才是root，开始层序遍历，最先找到的叶子结点就给他return
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //每个节点必有一个邻居，就算是一开始的root，他如果没有左右节点，那么它也有父亲为null与他相邻
            if (map.get(cur).size() <= 1) {
                return cur.val;
            }
            for (TreeNode neighbor : map.get(cur)) {
                if (neighbor != null && !visited.contains(neighbor.val)) {
                    queue.add(neighbor);
                    visited.add(neighbor.val); //
                }
            }
        }
        return -1;
    }


    //dfs 构建 图 的邻接表
    private void transToGraph(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        List<TreeNode> neighborList = map.getOrDefault(root, new ArrayList<>());
        neighborList.add(parent);
        map.put(root, neighborList);

        List<TreeNode> nodeList = map.getOrDefault(parent, new ArrayList<>());
        nodeList.add(root);
        map.put(parent, nodeList);

        transToGraph(root.left, map, root);
        transToGraph(root.right, map, root);
    }

//    示例 1：
//    输入：
//    root = [1, 3, 2], k = 1
//    二叉树图示：
//              1
//            / \
//            3   2
//
//    输出： 2 (或 3)
//    解释： 2 和 3 都是距离目标 1 最近的叶节点。
//
//    示例 2：
//    输入：
//    root = [1], k = 1
//    输出：1
//    解释： 最近的叶节点是根结点自身。
//
//    注：
//    root 表示的二叉树最少有 1 个结点且最多有 1000 个结点。
//    每个结点都有一个唯一的 node.val ，范围为 [1, 1000]。
//    给定的二叉树中有某个结点使得 node.val == k。

}
