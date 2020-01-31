package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

import BuddyStrings._

class BuddyStringsTest extends FlatSpec with Matchers {

  behavior of "BuddyStringsTest"

  it should "buddyStrings reversed length 2" in {
    buddyStrings("ab", "ba") shouldEqual true
  }

  it should "buddyStrings same length 2" in {
    buddyStrings("ab", "ab") shouldEqual false
  }

  it should "buddyStrings same with repeats" in {
    buddyStrings("aa", "aa") shouldEqual true
  }

  it should "buddyStrings diff last 2" in {
    buddyStrings("aaaaaaabc", "aaaaaaacb") shouldEqual true
  }

  it should "buddyStrings diff length" in {
    buddyStrings("", "aa") shouldEqual false
  }

}
