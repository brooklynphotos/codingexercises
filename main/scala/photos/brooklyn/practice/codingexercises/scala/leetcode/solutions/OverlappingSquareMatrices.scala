package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-84/problems/image-overlap/
  * Adopted from python solution
 * Assume index in A and B is [0, N * N -1]
 *
 * Loop on A, if value == 1, save its index to LA.
 * Loop on B, if value == 1, save its index to LB.
 * Loop on combination (i, j) of LA and LB, increase count[i - j] by 1.
 * If we slide to make A[i] orverlap B[j], we can get 1 point.
 * Loop on count and return max values.
 */
object OverlappingSquareMatrices {
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    val N = A.length
    val LA = for(x <- 0 until N*N; if A(x / N)(x %N)==1) yield x
    val LB = for(x <- 0 until N*N; if B(x / N)(x %N)==1) yield x
    val count = scala.collection.mutable.Map[Int, Int]()
    for(a <- LA){
      for(b <- LB){
        // a-b is the distance, so it's the same overlap configuration
        count(a-b) = count.getOrElse(a-b,0)+1
      }
    }
    count.values.max
  }

}
