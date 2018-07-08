package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-92/problems/transpose-matrix/
  */
object TransposeMatrix {

  private def updateArr(arr: Array[Array[Int]], index: Int, res: Array[Array[Int]]): Array[Array[Int]] = {
    val newRow = new Array[Int](arr.length)
    for(i <- 0 until newRow.length){
      newRow(i) = arr(i)(index)
    }
    res(index) = newRow
    res
  }

  def transposeArr(arr: Array[Array[Int]], index: Int, res: Array[Array[Int]]): Array[Array[Int]] =
    if(index==arr(0).length) res
    else transposeArr(arr, index+1, updateArr(arr, index, res))

  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = transposeArr(A, 0, new Array[Array[Int]](A(0).length))
}
