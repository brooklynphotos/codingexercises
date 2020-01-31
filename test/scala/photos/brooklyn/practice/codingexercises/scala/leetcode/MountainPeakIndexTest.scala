package photos.brooklyn.practice.codingexercises.scala.leetcode

import org.scalatest.{FlatSpec, Matchers}

import MountainPeakIndex._

class MountainPeakIndexTest extends FlatSpec with Matchers{

  behavior of "MountainPeakIndexTest"

  it should "peakIndexInMountainArray for three array" in {
    peakIndexInMountainArray(Array(0,1,0)) shouldEqual 1
  }

  it should "peakIndexInMountainArray for four array" in {
    peakIndexInMountainArray(Array(0,1,2,0)) shouldEqual 2
  }

  it should "peakIndexInMountainArray for longer odd array" in {
    peakIndexInMountainArray(Array(0,1,2,2,3,4,3,2,0)) shouldEqual 5
  }

  it should "peakIndexInMountainArray for longer even array" in {
    peakIndexInMountainArray(Array(0,1,2,2,3,4,7,3,2,0)) shouldEqual 6
  }

}
