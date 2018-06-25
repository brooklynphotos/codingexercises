package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-90/problems/buddy-strings/
  */
object BuddyStrings {

  def findDiffs(A: String, B: String): List[(Char, Char)] = A.zip(B).foldLeft(List[(Char, Char)]()){
    case (l, (a, b))=> if(a != b) (a,b)::l else l
  }

  def buddyStrings(A: String, B: String): Boolean =
    if(A.length != B.length) false
    else if(A==B && A.toSet.size<A.length) true
    else findDiffs(A, B) match {
      case (a1, b1)::(a2, b2)::Nil => a1==b2 && a2==b1
      case _ =>false
    }

}
