package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

object IncreasingOrderSearchTree {

  def increasingBST(root: TreeNode, tail: TreeNode=null): TreeNode =
    if (root == null) return tail
    else {
      val res = increasingBST(root.left, root)
      res.left = null
      res.right = increasingBST(root.right, tail)
      res
    }


}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

