package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

class MaxDistanceToClosestPersonTest extends FlatSpec with Matchers {

  behavior of "MaxDistanceToClosestPersonTest"

  it should "maxDistToClosest for example1" in {
    MaxDistanceToClosestPerson.maxDistToClosest(Array(1,0,0,0,1,0,1)) shouldEqual 2
  }

  it should "maxDistToClosest for example2" in {
    MaxDistanceToClosestPerson.maxDistToClosest(Array(1,0,0,0)) shouldEqual 3
  }

}
