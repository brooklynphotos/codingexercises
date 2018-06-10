package photos.brooklyn.practice.codingexercises.lang

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object ProducerConsumer {
  def interact(): Future[Seq[Any]] = {
    val p = Promise[Int]()
    val f = p.future

    val producer = Future{
      val r = sleep(2)
      if(r>3){
        p failure(new IllegalArgumentException("Can't be too long"))
      }else{
        p success r
        println("Done with producer")
      }
    }

    val consumer = Future{
      println("Starting to consume now")
      f foreach {
        r => println(s"Got ${r}")
      }
    }

    return Future.sequence(Seq(producer, consumer))
  }

  def sleep(i: Int): Int = {
    Thread.sleep(i*1000)
    i
  }

  def main(args: Array[String]): Unit = {
    val fs = interact()
    Await.result(fs, Duration.Inf)
  }
}
