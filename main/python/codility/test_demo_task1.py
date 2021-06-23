import unittest
import demo_task1 as dt

class TestDemo1(unittest.TestCase):
  def test_solution_ex1(self):
    self.assertEqual(5, dt.solution([1, 3, 6, 4, 1, 2]))

  def test_solution_ex2(self):
    self.assertEqual(4, dt.solution([1, 2, 3]))

  def test_solution_ex3(self):
    self.assertEqual(1, dt.solution([-1, -3]))

  def test_solution_single(self):
    self.assertEqual(2, dt.solution([1]))

  def test_solution_single_neg(self):
    self.assertEqual(1, dt.solution([-1]))


if __name__=='__main__':
  unittest.main()