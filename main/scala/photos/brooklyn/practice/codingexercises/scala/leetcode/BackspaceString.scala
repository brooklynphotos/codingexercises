package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * https://leetcode.com/contest/weekly-contest-87/problems/backspace-string-compare/
  */
object BackspaceString {
  def backspaceCompare(S: String, T: String): Boolean = typeOut(S)==typeOut(T)

  def typeOut(str: String): List[Char] = typeOut(str, 0, List[Char]())

  def applyNextChar(c: Char, stack: List[Char]): List[Char] =  if(c !='#') c::stack else if (stack==Nil) Nil else stack.tail

  @tailrec
  def typeOut(str: String, index: Int, stack: List[Char]): List[Char] =
    if(index==str.length) stack
    else typeOut(str, index+1, applyNextChar(str.charAt(index), stack))
}
