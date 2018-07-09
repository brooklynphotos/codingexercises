package photos.brooklyn.practice.codingexercises.scala.leetcode

import photos.brooklyn.practice.codingexercises.scala.leetcode.model.TreeNode

/**
  * https://leetcode.com/contest/weekly-contest-92/problems/smallest-subtree-with-all-the-deepest-nodes/
  */
object SmallestSubtreeWithDeepestNodes {

  def increment(res: (TreeNode, Int, Int)): (TreeNode, Int, Int) = (res._1, res._2+1, res._3+1)

  def findSubtree(node: TreeNode, depth: Int=0): (TreeNode, Int, Int) = (node.left, node.right) match{
    case (null, null) => (node, 0, 0) // if node is a leaf, it is its own answer
    case (left, null) => increment(findSubtree(left))
    case (null, right) => increment(findSubtree(right))
    case (left, right) => (findSubtree(left), findSubtree(right)) match {
      case (leftRes, rightRes) =>
        if(leftRes._3==rightRes._3) (node, 0, leftRes._3+1)
        else if(leftRes._3>rightRes._3) increment(leftRes)
        else increment(rightRes)
    }
  }

  def subtreeWithAllDeepest(root: TreeNode): TreeNode = findSubtree(root)._1
}


