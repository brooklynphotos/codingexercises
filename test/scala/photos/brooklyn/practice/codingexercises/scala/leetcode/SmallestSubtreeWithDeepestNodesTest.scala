package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}
import photos.brooklyn.practice.codingexercises.scala.leetcode.model.TreeNode
import SmallestSubtreeWithDeepestNodes._

class SmallestSubtreeWithDeepestNodesTest extends FlatSpec with Matchers {

  behavior of "SmallestSubtreeWithDeepestNodesTest"

  it should "subtreeWithAllDeepestTest1" in {
    val tree = SmallestSubtreeWithDeepestNodesTest.parseToNode(Array(3,5,1,6,2,0,8,-1,-1,7,4))
    val res = subtreeWithAllDeepest(tree)
    res shouldEqual 2
  }

}

object SmallestSubtreeWithDeepestNodesTest{
  def parseToNode(arr: Array[Int]): TreeNode = {
    val node = new TreeNode(arr(0))
    node.left = new TreeNode(arr(1))
    node.right = new TreeNode(arr(2))
    node.left.left = new TreeNode(arr(3))
    node.left.right = new TreeNode(arr(4))
    node.right.left = new TreeNode(arr(5))
    node.right.right = new TreeNode(arr(6))
    node.right.right = new TreeNode(arr(6))
    node.left.right.left = new TreeNode(arr(9))
    node.left.right.right = new TreeNode(arr(10))
    node
  }

//  def toArray(treeNode: TreeNode): List[Int] = treeNode._value :: toArray()
}
