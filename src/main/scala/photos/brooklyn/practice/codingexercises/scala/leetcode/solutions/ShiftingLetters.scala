package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

/**
  * Based on java solution: https://leetcode.com/problems/shifting-letters/discuss/137906/C++JavaPython-Easy-Understood
  */
object ShiftingLetters {

  def mergeShifts(shifts: Array[Int]): List[Int] = shifts.foldRight(List[Int]())((shift, resList)=>resList match{
    case prev::rest =>(shift+prev)%26 :: prev :: rest
    case _ => shift%26 :: resList
  })

  def shiftLetters(charArr: Array[Char], shifts: List[Int]): Seq[Char] = for(i <- 0 until charArr.length) yield ((charArr(i) - 'a' + shifts(i)) % 26 + 'a').toChar

  def shiftingLetters(S: String, shifts: Array[Int]): String = shiftLetters(S.toCharArray, mergeShifts(shifts)).mkString

}
