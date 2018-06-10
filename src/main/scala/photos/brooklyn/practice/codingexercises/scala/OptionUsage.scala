package photos.brooklyn.practice.codingexercises.scala

object OptionUsage {

  private def getOdd(x: Int): Option[Int] = if(x%2==1) Some(x) else None
  private def makeString(x: Int): Option[String] = Option(x.toString)

  def filter(x: Int): Boolean = getOdd(x).filter(x => x % 5==0)==Some(x)

  def foreach(x: Int): Int = (for{
      o <- getOdd(x)
      s <- makeString(o)
      n <- Option(s.length)
    } yield n) match{
      case Some(q) => q
      case None => 0
    }
}
