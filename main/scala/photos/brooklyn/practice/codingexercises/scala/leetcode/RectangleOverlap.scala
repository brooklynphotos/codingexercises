package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-85/problems/rectangle-overlap/
  */
object RectangleOverlap {
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = !(
    // Ax2 <= Bx1 || Ay2<=By1 || Ax1>=Bx2 || Ay1>=By2
    rec1(2) <= rec2(0) || rec1(3) <= rec2(1) || rec1(1) >= rec2(3) || rec1(0) >= rec2(2)
    )
}
