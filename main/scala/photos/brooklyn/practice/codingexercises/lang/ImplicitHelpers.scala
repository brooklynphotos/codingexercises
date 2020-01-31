package photos.brooklyn.practice.codingexercises.lang

object ImplicitHelpers {
  implicit class IntWithTimes(x: Int){
    def times(f: =>Unit): Unit = {
      for(_ <- 0 until x) f
    }

    def ::(y: Int): Int = (y.toString + x).toInt
  }

  def main(args: Array[String]): Unit = {
    3 times {
      println("Once")
    }

    val r = 4 :: 3
    println(r)
  }
}
