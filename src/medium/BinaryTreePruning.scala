/*
https://leetcode.com/problems/binary-tree-pruning/description/
We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
*/
/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object BinaryTreePruning {
    
    implicit class TreeNodeImprovements(node: TreeNode) {
        def isLeaf = node.left == null && node.right == null
    }
    
    def prune(node: TreeNode) : Boolean = {
        if(node.left != null){
            if(prune(node.left)){
                node.left = null
            }
        }
        if(node.right != null){
            if(prune(node.right)){
                node.right = null
            }
        }
        if(node.isLeaf && node.value == 0){
            true
        } else {
            false
        }
    }
    
    def pruneTree(root: TreeNode): TreeNode = {
        prune(root)
        root
    }
}
