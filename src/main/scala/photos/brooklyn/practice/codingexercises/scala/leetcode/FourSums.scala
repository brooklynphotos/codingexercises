package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.collection.mutable.ArrayBuffer

/**
  * https://leetcode.com/problems/4sum/
  */
class FourSums {
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = nSum(4, nums, target)



  def nSum(n: Int, nums: Array[Int], target: Int): List[List[Int]] =
    if(n>1) {
      val numSet = nums.toSet
      numSet.flatMap(x => {
        val s = nSum(n - 1, nums - x, target - x)
        val r = s match {
          case List(Nil) => s
          case _ => s.map(l => x :: l)
        }
        r
      }
      ).toList
    }else
      if(nums.contains(target))
        List(List(target))
      else
        List(List())


  implicit class BetterList(l: Array[Int]){

    def removeOnce(l: Array[Int], x: Int): Array[Int] = l.indexOf(x) match {
      case -1 => l
      case i => l.take(i) ++ l.drop(i + 1)
    }

    def -(x: Int): Array[Int] = removeOnce(l, x)
  }
}

