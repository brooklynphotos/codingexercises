package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

import org.scalatest.{FlatSpec, Matchers}
import LemonadeChange._
import photos.brooklyn.practice.codingexercises.scala.leetcode.utils.LemonadeChangeUtils._

class LemonadeChangeTest extends FlatSpec with Matchers{

  behavior of "LemonadeChangeTest"

  it should "lemonadeChangeEnoughChange" in {
    val bills = Array(5,5,5,10,20)
    lemonadeChange(bills) shouldBe true
  }

  it should "lemonadeChangeTooSoon" in {
    val bills = Array(10,10)
    lemonadeChange(bills) shouldBe false
  }

  it should "lemonadeChangeEnoughChangeShort" in {
    val bills = Array(5,5,10)
    lemonadeChange(bills) shouldBe true
  }

  it should "lemonadeChangeTooSoonMiddle" in {
    val bills = Array(5,5,10,10,20)
    lemonadeChange(bills) shouldBe false
  }

  it should "lemonadeChangeLong" in {
    val bills = readLongQueue("long_queue1")
    lemonadeChange(bills) shouldBe true
  }

  it should "lemonadeChangeLong2" in {
    val bills = readLongQueue("long_queue2")
    lemonadeChange(bills) shouldBe true
  }

}
