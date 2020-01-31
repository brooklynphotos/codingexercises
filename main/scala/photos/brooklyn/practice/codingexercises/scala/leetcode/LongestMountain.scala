package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-87/problems/longest-mountain-in-array/
  */
object LongestMountain {
  def longestMountain(A: Array[Int]): Int = walkMountain(A)

  def walkMountain(arr: Array[Int], ascending: Int=0, descending: Int=0, index: Int=0, res: Int=0): Int =
    if(arr.length==index) res
    else (ascending, descending) match {
      // we are at the beginning
      case (0, _) => walkMountain(arr, 2, 0, index + 1)
      case (1, 1) => arr(index) match {
        case x if (x > ascending) => walkMountain(arr, 3, 0, index + 1)
        case x if (x == ascending) => walkMountain(arr, 4, 0, index + 1)
        case x if (x < ascending) => walkMountain(arr, 4, 1, index + 1)
      }
    }
}
