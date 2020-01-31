package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * https://leetcode.com/contest/weekly-contest-100/problems/monotonic-array/
  */
object MonotonicArray {
  def isMonotonic(A: Array[Int]): Boolean = {
    if(A.length==1) true
    else isMonotonicLonger(A, 1, A(0))
  }

  @tailrec
  def isMonotonicLonger(A: Array[Int], currentIndex: Int, prevValue: Int, diffSum: Int=0): Boolean =
    if (currentIndex == A.length) true
    else A(currentIndex) - prevValue match {
      case diff if (diff>0 && diffSum<0) || (diff<0 && diffSum>0) => false
      case diff => isMonotonicLonger(A, currentIndex + 1, A(currentIndex), diffSum + diff)
    }
}
