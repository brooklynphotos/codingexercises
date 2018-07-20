package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}
import ShortestPathToAllKeys._

class ShortestPathToAllKeysTest extends FlatSpec with Matchers {

  behavior of "ShortestPathToAllKeysTest"

  it should "shortestPathAllKeys for test 1" in {
    shortestPathAllKeys(Array("@.a.#", "###.#", "b.A.B")) shouldEqual 8
  }
  it should "shortestPathAllKeys for test 2" in {
    shortestPathAllKeys(Array("@..aA", "..B#.", "....b")) shouldEqual 6
  }
  it should "shortestPathAllKeys for test 3" in {
    shortestPathAllKeys(Array("@..a", "##.#", ".bA.")) shouldEqual 7
  }
  it should "shortestPathAllKeys for test impossible" in {
    shortestPathAllKeys(Array("@..a", "####", ".bA.")) shouldEqual -1
  }
  it should "shortestPathAllKeys for test impossible 2" in {
    shortestPathAllKeys(Array("@Aa")) shouldEqual -1
  }

}
