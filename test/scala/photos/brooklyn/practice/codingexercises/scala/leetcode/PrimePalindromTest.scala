package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}
import photos.brooklyn.practice.codingexercises.scala.leetcode.PrimePalindrom._

class PrimePalindromTest extends FlatSpec with Matchers {

  behavior of "PrimePalindromTest"

  it should "primePalindrome test8" in {
    primePalindrome(8) shouldEqual 11
  }

  it should "primePalindrome test_9989900" in {
    primePalindrome(9989900) shouldEqual 100030001
  }

  it should "primePalindrome test_13" in {
    primePalindrome(13) shouldEqual 101
  }

  it should "primePalindrome test_3" in {
    primePalindrome(3) shouldEqual 3
  }

}
