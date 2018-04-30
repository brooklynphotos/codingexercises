package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-82/problems/goat-latin/
  */
object GoatLatin {

  val vowels = Array('a','e','i','o','u')

  def toGoatWord(word: String): String = if(!vowels.contains(word(0).toLower)) word.substring(1) + word(0) + "ma" else word + "ma"

  def toGoatLatin(strs: List[String], suffix: String="a"): List[String] = strs match {
    case head::rest => toGoatWord(head) + suffix :: toGoatLatin(rest, suffix+"a")
    case Nil => List.empty
  }

  def toGoatLatin(s: String): String = if(s==null || s.length==0) "" else toGoatLatin(s.split("\\s+").toList).mkString(" ")
}
