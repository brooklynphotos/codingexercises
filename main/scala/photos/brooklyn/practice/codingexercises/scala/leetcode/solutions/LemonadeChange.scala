package photos.brooklyn.practice.codingexercises.scala.leetcode.solutions

object LemonadeChange {

  def isDoable(bills: Array[Int], customer: Int=0, five: Int=0, ten: Int=0): Boolean =
    if(five<0) false
    else if(bills.length==customer) true
    else bills(customer) match{
      case bill if bill==5 => isDoable(bills, customer+1, five+1, ten)
      case bill if bill==10 => isDoable(bills, customer+1, five-1, ten+1)
      case _ => if(ten>0) isDoable(bills, customer+1, five-1, ten-1) else isDoable(bills, customer+1, five-3, ten)
    }

  def lemonadeChange(bills: Array[Int]): Boolean = isDoable(bills)

}
