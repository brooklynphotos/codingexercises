package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.FlatSpec

class RectangleOverlapTest extends FlatSpec {

  behavior of "testIsRectangleOverlap"

  it should "pass given overlap" in {
    val rec1 = Array(0,0,2,2)
    val rec2 = Array(1,1,3,3)
    assert(RectangleOverlap.isRectangleOverlap(rec1, rec2) == true)
  }

  it should "pass given another overlap" in {
    val rec1 = Array(7,8,13,15)
    val rec2 = Array(10,8,12,20)
    assert(RectangleOverlap.isRectangleOverlap(rec1, rec2) == true)
  }

  it should "not pass given no overlap" in {
    val rec1 = Array(0,0,1,1)
    val rec2 = Array(1,0,2,1)
    assert(RectangleOverlap.isRectangleOverlap(rec1, rec2) == false)
  }
  it should "not pass given just tangential on X" in {
    val rec1 = Array(0,0,1,1)
    val rec2 = Array(0,-1,1,0)
    assert(RectangleOverlap.isRectangleOverlap(rec1, rec2) == false)
  }
  it should "not pass given no tangential on Y" in {
    val rec1 = Array(0,0,1,1)
    val rec2 = Array(-1,0,0,1)
    assert(RectangleOverlap.isRectangleOverlap(rec1, rec2) == false)
  }
}
