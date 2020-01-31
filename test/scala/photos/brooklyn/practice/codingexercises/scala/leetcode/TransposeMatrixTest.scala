package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}
import TransposeMatrix._

class TransposeMatrixTest extends FlatSpec with Matchers{

  behavior of "TransposeMatrixTest"

  it should "transposeSquare" in {
    transpose(Array(Array(1,2,3),Array(4,5,6), Array(7,8,9))) shouldEqual Array(Array(1,4,7), Array(2,5,8), Array(3,6,9))
  }

  it should "transpose2x3" in {
    transpose(Array(Array(1,2,3),Array(4,5,6))) shouldEqual Array(Array(1,4), Array(2,5), Array(3,6))
  }

  it should "transpose3x2" in {
    transpose(Array(Array(1,2),Array(3,4), Array(5,6))) shouldEqual Array(Array(1,3,5), Array(2,4,6))
  }

}
