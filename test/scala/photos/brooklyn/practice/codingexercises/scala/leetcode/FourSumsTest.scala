package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, MustMatchers}

class FourSumsTest extends FlatSpec with MustMatchers{

  behavior of "FourSumsTest"

  it should "fourSum for testcase1" in {
    val sol = new FourSums().fourSum(Array(1, 0, -1, 0, -2, 2), 0)
    sol.length mustEqual 4
  }

  it should "twoSum for testcase2" in {
    val sol = new FourSums().nSum(2, Array(1, 0, -1), 0)
    sol.length mustEqual 4
  }

}
