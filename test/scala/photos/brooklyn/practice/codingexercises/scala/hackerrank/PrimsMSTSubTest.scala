package photos.brooklyn.practice.codingexercises.scala.hackerrank

import org.scalatest.{FlatSpec, Matchers}

class PrimsMSTSubTest extends FlatSpec with Matchers {

  behavior of "PrimsMSTSubTest"

  it should "prims on first example" in {
    val n = 5
    val edges = Array(
      Array(1, 2, 3),
      Array(1, 3, 4),
      Array(4, 2, 6),
      Array(5, 2, 2),
      Array(2, 3, 5),
      Array(3, 5, 7)
    )
    val start = 1
    PrimsMSTSub.prims(n, edges, start) shouldEqual 15
  }

}
