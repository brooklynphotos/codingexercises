package photos.brooklyn.practice.codingexercises.scala

import org.scalatest.{FlatSpec, Matchers}

class OptionUsageTest extends FlatSpec with Matchers{

  behavior of "OptionUsageTest"

  it should "filter something in" in {
    OptionUsage.filter(15) shouldEqual true
  }

  it should "filter even out" in {
    OptionUsage.filter(10) shouldEqual false
  }

  it should "filter non-5 odds out" in {
    OptionUsage.filter(9) shouldEqual false
  }

  it should "find the length of the right number" in {
    OptionUsage.foreach(15) shouldEqual 2
  }

  it should "return 0 for the wrong number" in {
    OptionUsage.foreach(10) shouldEqual 0
  }

}
