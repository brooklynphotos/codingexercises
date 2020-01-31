package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}
import XOfAKindDeckOfCards._

class XOfAKindDeckOfCardsTest extends FlatSpec with Matchers {

  behavior of "XOfAKindDeckOfCardsTest"

  it should "be true with 1,2,3,4 being 2" in {
    val a = Array(1,2,3,4,4,3,2,1)
    hasGroupsSizeX(a) shouldBe true
  }
  it should "be true with multiples being 2" in {
    val a = Array(1,1,2,2,2,2)
    hasGroupsSizeX(a) shouldBe true
  }
  it should "be true with common factor" in {
    val a = Array(1,1,1,1,2,2,2,2,2,2)
    hasGroupsSizeX(a) shouldBe true
  }

  it should "be false with 1=2, 2=5" in {
    val a = Array(1,1,2,2,2,2,2)
    hasGroupsSizeX(a) shouldBe false
  }
}
