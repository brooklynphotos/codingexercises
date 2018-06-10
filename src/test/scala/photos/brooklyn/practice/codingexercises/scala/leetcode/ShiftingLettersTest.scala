package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

class ShiftingLettersTest extends FlatSpec with Matchers {

  behavior of "ShiftingLetters"

  it should "shiftingLetters" in {
    ShiftingLetters.shiftingLetters("abc", Array(3,5,9)) shouldEqual "rpl"
  }

}
