package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.FlatSpec

class BackspaceStringTest extends FlatSpec {

  behavior of "BackspaceStringTest"

  it should "backspaceCompare for true strings" in {
    assert(BackspaceString.backspaceCompare("a##c", "#a#c"))
  }

  it should "backspaceCompare for another true strings" in {
    assert(BackspaceString.backspaceCompare("ab##", "c#d#"))
  }

  it should "backspaceCompare for false strings" in {
    assert(!BackspaceString.backspaceCompare("a#c", "b"))
  }

}
