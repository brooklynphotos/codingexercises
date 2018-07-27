package photos.brooklyn.practice.codingexercises.scala.leetcode

import scala.annotation.tailrec
import scala.collection.immutable.Queue

/**
  * TODO fails time limit, but might just be that it's using immutable datatypes
  * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
  */
object IslandCount {
  def nextCoordinate(grid: Array[Array[Char]], currentLocation: (Int, Int)): (Int, Int) = currentLocation match {
    case (row, col) => if(col+1==grid(0).length) (row+1, 0) else (row, col+1)
  }

  @tailrec
  def markLand(grid: Array[Array[Char]], marked: Set[(Int, Int)], queue: Queue[(Int, Int)]): Set[(Int, Int)] =
    if (queue.isEmpty) marked
    else queue.dequeue match {
      case ((row, col), shrankQueue) => {
        val newQueue = shrankQueue ++ List((row - 1, col), (row, col - 1), (row + 1, col), (row, col + 1))
          .filterNot {
            case (r, c) =>
              r < 0 || c < 0 || r == grid.length || c == grid(r).length || marked.contains((r, c)) || grid(r)(c)=='0'
          }
        markLand(grid, marked + Tuple2(row, col), newQueue)
      }
    }

  def walkLand(grid: Array[Array[Char]], currentLocation: (Int, Int), marked: Set[(Int, Int)], count: Int): Int =
    if(marked contains currentLocation) walkLand(grid, nextCoordinate(grid, currentLocation), marked, count)
    else currentLocation match {
      case (row, col) =>
        if (row == grid.length) count
        else grid(row)(col) match {
          case v if v == '0' => walkLand(grid, nextCoordinate(grid, currentLocation), marked, count)
          case _ => walkLand(grid, nextCoordinate(grid, currentLocation), markLand(grid, marked, Queue(currentLocation)), count + 1)
        }
  }

  def numIslands(grid: Array[Array[Char]]): Int = walkLand(grid, (0,0), Set[(Int, Int)](),0)
}
