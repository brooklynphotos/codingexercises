package photos.brooklyn.practice.codingexercises.scala.leetcode

import photos.brooklyn.practice.codingexercises.scala.leetcode.model.TreeNode

/**
  * https://leetcode.com/contest/weekly-contest-92/problems/smallest-subtree-with-all-the-deepest-nodes/
  */
object SmallestSubtreeWithDeepestNodes {

  def increment(res: (TreeNode, Int)): (TreeNode, Int) = (res._1, res._2+1)

  def findSubtree(node: TreeNode): (TreeNode, Int) = if(node==null) (node, -1) else
    (findSubtree(node.left), findSubtree(node.right)) match {
      case (leftRes, rightRes) =>
        if(leftRes._2==rightRes._2) (node, leftRes._2+1)
        else if(leftRes._2>rightRes._2) increment(leftRes)
        else increment(rightRes)
    }

  def subtreeWithAllDeepest(root: TreeNode): TreeNode = findSubtree(root)._1
}


