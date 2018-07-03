package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec

/**
  * https://leetcode.com/contest/weekly-contest-90/problems/score-of-parentheses/
  */
object ScoreOfParentheses {
  def scoreOfParentheses(S: String): Int = walkParentheses(S)

  /**
    * there is a layer above which we are building the scores. So with a simple (), with have two layers:
    * 1. the layer to keep the score of the string
    * 2. another layer within () to figure out what the score is for ()
    * Similarly, we have one bottom layer for ()(), and then another layer is created and then destroyed to figure out
    * (), and another one for the second ()
    * @param str original string
    * @param pointer character position to consider
    * @param stack keeps track of which layer of the () we are in
    * @return
    */
  @tailrec
  def walkParentheses(str: String, pointer: Int=0, stack: List[Int]=List(0)): Int =
    if(str.length==pointer)
      stack.head
    else if(str.charAt(pointer)=='(')
      walkParentheses(str, pointer+1, 0::stack)
    else stack match{
      case head::container::tail => walkParentheses(str, pointer+1, container+getScore(head)::tail)
    }

  def getScore(layer: Int) = if(layer==0) 1 else layer * 2
}