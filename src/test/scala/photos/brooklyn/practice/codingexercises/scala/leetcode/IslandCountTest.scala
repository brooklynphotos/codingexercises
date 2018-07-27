package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

class IslandCountTest extends FlatSpec with Matchers {

  behavior of "IslandCountTest"

  it should "numIslands be 1" in {
    val grid = IslandCountTest.parse("""11110
                       |11010
                       |11000
                       |00000""")
    IslandCount.numIslands(grid) shouldBe 1
  }

}

object IslandCountTest{

  def parse(str: String): Array[Array[Char]] = str.split("\\s*\n\\s*").map(l=>l.toCharArray.filter(c=>c=='1' || c=='0'))

}