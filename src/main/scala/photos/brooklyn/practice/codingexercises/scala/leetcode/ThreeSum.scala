package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

object ThreeSum {

  def toList(intToIntToInt: Map[Int, Map[Int, Int]]): scala.List[scala.List[Int]] = ???

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    scala.util.Sorting.quickSort(nums)
    toList(threeSum(nums.toList))
  }

  @tailrec
  def threeSum(nums: List[Int], accumulator: scala.collection.mutable.Map[Int, Map[Int, Int]] = scala.collection.mutable.Map()): Map[Int, Map[Int, Int]] = {
    if(nums.length==3){
      return accumulator.toMap + (nums(0) -> Map(nums(1) -> nums(2)))
    }
    val head::rest = nums
    if(!accumulator.contains(head)) {
      // new number
      val res = findPairs(rest, 0 - head)
      if(res != null) accumulator(head) = Map(res._1->res._2)
    }
    return threeSum(rest, accumulator)
  }

  /**
    * given a list of ints, find the pairs each summing to the given sum
    * @param ints
    * @param sum
    * @return
    */
  def findPairs(ints: List[Int], sum: Int): (Int, Int) = ???

}
