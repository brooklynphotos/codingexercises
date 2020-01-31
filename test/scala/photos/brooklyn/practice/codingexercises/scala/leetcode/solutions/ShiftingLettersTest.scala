package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

import org.scalatest.{FlatSpec, Matchers}

class ShiftingLettersTest extends FlatSpec with Matchers {

  behavior of "ShiftingLetters"

  it should "mergeShifts" in {
    ShiftingLetters.mergeShifts(Array(2, 3, 4)) shouldEqual Array(9, 7, 4)
    ShiftingLetters.mergeShifts(Array(3,5,9)) shouldEqual Array(17,14,9)

  }

  it should "shiftingLetters" in {
    ShiftingLetters.shiftingLetters("abc", Array(3,5,9)) shouldEqual "rpl"
  }

}
