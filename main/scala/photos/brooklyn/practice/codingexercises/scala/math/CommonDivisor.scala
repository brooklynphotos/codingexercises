package photos.brooklyn.practice.codingexercises.scala.math

object CommonDivisor {
  def gcd(a: Int, b: Int): Int = if(a==0) b else gcd(b%a, a)

  def countAllDivisors(a: Int, b: Int): Int = (1 to gcd(a,b)).foldLeft(0)((t,x)=>t+(if(a%x==0 && b%x==0)1 else 0))
}
