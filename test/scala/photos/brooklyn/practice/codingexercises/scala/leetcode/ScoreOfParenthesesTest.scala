package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

import ScoreOfParentheses._

class ScoreOfParenthesesTest extends FlatSpec with Matchers {

  behavior of "ScoreOfParenthesesTest"

  it should "walkParentheses1" in {
    scoreOfParentheses("()") shouldEqual 1
  }

  it should "walkParenthesesEnclosed" in {
    scoreOfParentheses("(())") shouldEqual 2
  }

  it should "walkParenthesesDouble" in {
    scoreOfParentheses("()()") shouldEqual 2
  }

  it should "walkParenthesesComplex1" in {
    scoreOfParentheses("(()(()))") shouldEqual 6
  }

  it should "walkParenthesesComplex2" in {
    scoreOfParentheses("(()())()") shouldEqual 5
  }

  it should "walkParenthesesTwoEnclosed" in {
    scoreOfParentheses("(())(())") shouldEqual 4
  }

}
