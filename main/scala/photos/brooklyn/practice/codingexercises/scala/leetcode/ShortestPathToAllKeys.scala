package photos.brooklyn.practice.codingexercises.scala.leetcode

object ShortestPathToAllKeys {

  private def parseGrid(grid: Array[String]): (Array[Array[Char]], (Int, Int), Set[Char]) = {
    val resArr = new Array[Array[Char]](grid.length)
    var start: Option[(Int, Int)] = None
    var keys = Set[Char]()
    for(r <- 0 until grid.length){
      val row = grid(r)
      resArr(r) = row.toCharArray
      for(c <- 0 until row.length){
        val ch = row(c)
        if(ch=='@'){
          start = Some((r, c))
        }
        if(ch.isLower){
          keys += ch
        }
      }
    }
    (resArr, start.get, keys)
  }

  /**
    * follow all the possible paths and collect the steps until either we have all the keys or exhausted the paths
    *
    * @param matrix the board we are crawling around
    * @param queue the states from having made the steps
    * @param allKeys all the keys already discovered in the matrix
    * @param visited states that have already been visited and should be ignored
    * @return
    */
  def findShortestPathBSF(matrix: Array[Array[Char]], queue: List[State], allKeys: Set[Char], visited: Set[State], steps: Int): Int = queue match {
    case Nil => -1
    case _ =>
      val R = matrix.length
      val C = matrix(0).length
      val newMembers = queue
        .flatMap(
          s => List(
            (s.row - 1, s.col),
            (s.row, s.col - 1),
            (s.row + 1, s.col),
            (s.row, s.col + 1)
          )
          .filterNot {
            case (r, c) =>
              // outside the matrix
              r < 0 || r >= R || c < 0 || c >= C ||
              // or encounters a wall or a lock you don't have a key for
              (matrix(r)(c) match {
                case elem => elem == '#' || (elem.isUpper && !s.keys(elem.toLower))
              })
          }
          .map {
            case (r, c) => State(r, c, if (matrix(r)(c).isLower) s.keys + matrix(r)(c) else s.keys)
          }
          .filterNot(visited.contains)
        )
      val winner = newMembers.filter(s => s.keys == allKeys)
      // update visited
      if (winner == Nil) findShortestPathBSF(matrix, newMembers, allKeys, visited ++ newMembers, steps + 1) else steps
    }


  private def findShortestPath(matrix: Array[Array[Char]], startState: State, allKeys: Set[Char]): Int = {
    if(allKeys==Set[Char]()) 0
    else {
      val visited = Set[State]()
      val queue = List(startState)
      findShortestPathBSF(matrix, queue, allKeys, visited, 1)
    }
  }

  def shortestPathAllKeys(grid: Array[String]): Int = {
    val (matrix, startCoord, keys) = parseGrid(grid)
    findShortestPath(matrix, State(startCoord._1, startCoord._2, Set[Char]()), keys)
  }

  case class State(row: Int, col: Int, keys: Set[Char])

}
