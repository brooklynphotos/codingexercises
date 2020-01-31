package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-86/problems/split-array-into-fibonacci-sequence/
  *
  * 1. Given a stack of numbers
  *   a. if it's empty, then put the first character in it
  *   b. if it has only one substring already, try the next substring of the next character
  *   c. if it has at least two substring, find the sum of the top two, and for those many digits, read the next string as int.
  *      i. if that next int == sum, push this next int into the stack
  *      ii. otherwise, start over again with the oldest two, add a digit to the penultimate one and repeat #c
  *         1. if there is no more string, then pop the penultimate one, and add another digit to the last one, repeat #b
  *   d. if the only item in the stack is actually the string itself, then the is no answer
  *   e. else the stack is the answer
  */
object FibonaccilikeSequence {
  def splitIntoFibonacci(S: String): List[Int] = split(S,List[Int](S.charAt(1), S.charAt(0)), S)

  def split(str: String, stack: List[Int], origString: String): List[Int] = if(str.length==0) stack else stack match {
    case x::y::tail => {
      val sum = x+y
      val candidateStr = str.substring(0,sum.toString.length)
      val candidate = candidateStr.toInt
      if(candidate==sum){
        split(str.substring(candidateStr.length), candidate::stack, origString)
      }else{
        // start again
        // find the original two starters because everything after should be now invalid
        val a::b::Nil = stack.drop(stack.size-2)
        val aIndex = a.toString.length - 1
        val bIndex = (a.toString.length+b.toString.length) - 1
        // if we have no more string left after b then b is not a possibility, change A
        if(bIndex==origString.length-1){
          val newAIndex = aIndex+1
          if(newAIndex==origString.length){
            List[Int]() // we have an A that is the size of the actual string, so we can't find a solution
          }else{
            val newBIndex = newAIndex+1
            val newA = origString.substring(0, newAIndex).toInt
            val newB = origString.substring(newAIndex, newBIndex).toInt
            split(origString.substring(newAIndex+1), List(newB, newA), origString)
          }
        }else{
          val newBIndex = bIndex+1
          val newB = origString.substring(aIndex, newBIndex).toInt
          split(origString.substring(newBIndex+1), List(newB, a), origString)
        }
      }
    }
  }

  def splitFib(str: String, n1: Int, n2: Int): List[Int] = ???

}
