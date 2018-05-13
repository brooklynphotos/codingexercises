package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

import org.scalatest.{FlatSpec, Matchers}

class OverlappingSquareMatricesTest extends FlatSpec with Matchers {

  behavior of "OverlappingSquareMatrices"

  it should "come up with a 3 in the test case" in {
    val A = Array(Array(1, 1, 0), Array(0, 1, 0), Array(0, 1, 0))
    val B = Array(Array(0, 0, 0), Array(0, 1, 1), Array(0, 0, 1))
    OverlappingSquareMatrices.largestOverlap(A, B) shouldEqual 3
  }

}
