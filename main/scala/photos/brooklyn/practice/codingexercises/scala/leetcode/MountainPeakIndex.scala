package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * https://leetcode.com/contest/weekly-contest-89/problems/peak-index-in-a-mountain-array/
  */
object MountainPeakIndex {

  @tailrec
  def findPeak(arr: Array[Int], start: Int, until: Int): Int = {
    val midpoint = (until+start) / 2
    return (arr(midpoint-1), arr(midpoint), arr(midpoint + 1)) match {
      case (a, m, b) if(m>=b) => if(a<m) midpoint else findPeak(arr, start, midpoint)
      case (_, m, b) if(m<b) => findPeak(arr, midpoint+1, until)
    }
  }

  def peakIndexInMountainArray(A: Array[Int]): Int = findPeak(A, 0, A.length)

}
