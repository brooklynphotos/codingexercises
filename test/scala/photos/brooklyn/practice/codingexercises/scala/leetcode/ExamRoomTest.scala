package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

class ExamRoomTest extends FlatSpec with Matchers {

  behavior of "ExamRoomTest"

  it should "findBiggestMiddleDistance for nonempty list" in {
    val r = new ExamRoom(10)
    r.findBiggestMiddleDistance(List(4,9)) shouldEqual (4,9)
  }

  it should "follow the correct order test 1" in {
    val r = new ExamRoom(10)
    r.seat() shouldEqual 0
    r.seat() shouldEqual 9
    r.seat() shouldEqual 4
    r.seat() shouldEqual 2
    r.leave(4)
    r.seat() shouldEqual 5
  }

  it should "follow the correct order test 3" in {
    val r = new ExamRoom(10)
    r.seat() shouldEqual 0
    r.seat() shouldEqual 9
    r.seat() shouldEqual 4
    r.leave(0)
    r.leave(4)
    r.seat() shouldEqual 0
    r.seat() shouldEqual 4
    r.seat() shouldEqual 2
    r.seat() shouldEqual 6
    r.seat() shouldEqual 1
    r.seat() shouldEqual 3
    r.seat() shouldEqual 5
    r.seat() shouldEqual 7
    r.seat() shouldEqual 8
    r.leave(0)
    r.leave(4)
    r.seat() shouldEqual 0
  }

  it should "follow the correct order test 4" in {
    val r = new ExamRoom(8)
    r.seat() shouldEqual 0
    r.seat() shouldEqual 7
    r.seat() shouldEqual 3
    r.leave(0)
    r.leave(7)
    r.seat() shouldEqual 7
    r.seat() shouldEqual 0
    r.seat() shouldEqual 5
    r.seat() shouldEqual 1
    r.seat() shouldEqual 2
    r.seat() shouldEqual 4
    r.seat() shouldEqual 6
  }

}
