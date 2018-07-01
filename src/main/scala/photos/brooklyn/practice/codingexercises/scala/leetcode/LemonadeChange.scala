package photos.brooklyn.practice.codingexercises.scala.leetcode

/**
  * https://leetcode.com/contest/weekly-contest-91/problems/lemonade-change/
  */
object LemonadeChange {

  def addToCashier(newBill: Int, cashier: Map[Int, Int]): Map[Int, Int] = cashier + (newBill->(cashier(newBill)+1))

  def subtractFromCashier(cashier: Map[Int, Int], bill: Int, count: Int): Map[Int, Int] = cashier + (bill->(cashier(bill) - count))

  /**
    * attempts to give change and add the new bill
    *
    * @param change this can only be 5-5, 10-5, or 20-5
    * @param cashier keys are at most 5, 10, and 20 (which is useless)
    * @return
    */
  private def transact(change: Int, cashier: Map[Int, Int], newBill: Int): Option[Map[Int, Int]] =
    if(change==0) Some(addToCashier(newBill, cashier))
    else if(change==5 && cashier(5) > 0) Some(subtractFromCashier(addToCashier(newBill, cashier), 5, 1))
    else if(change==15)
      if(cashier(5)>0 && cashier(10)>0)
        Some(subtractFromCashier(subtractFromCashier(addToCashier(newBill, cashier),5,1), 10, 1))
      else if(cashier(5)>=3)
        Some(subtractFromCashier(addToCashier(newBill, cashier),5,3))
      else
        None
    else
        None

  def isDoable(bills: Array[Int], customer: Int=0, cashier: Map[Int, Int] = Map(5->0, 10->0, 20->0)): Boolean = if(bills.length==customer) true
  else {
    val bill = bills(customer)
    val change = bill - 5
    // do I have change?
    val res = transact(change, cashier,bill)
    if(res.isEmpty) false
    else isDoable(bills, customer+1, res.get)
  }

  def lemonadeChange(bills: Array[Int]): Boolean = if(bills.length==0) true else isDoable(bills)
}
