package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

class MonotonicArrayTest extends FlatSpec with Matchers {

  behavior of "MonotonicArrayTest"

  it should "isMonotonic example 1" in {
    MonotonicArray.isMonotonic(Array(1,2,2,3)) shouldEqual true
  }

  it should "isMonotonic example 3" in {
    MonotonicArray.isMonotonic(Array(1,3,2)) shouldEqual false
  }

  it should "isMonotonic example 2" in {
    MonotonicArray.isMonotonic(Array(6,5,4,4)) shouldEqual true
  }

  it should "isMonotonic example same" in {
    MonotonicArray.isMonotonic(Array(1,1,1)) shouldEqual true
  }

}
