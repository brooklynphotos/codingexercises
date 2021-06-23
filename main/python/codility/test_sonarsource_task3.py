import unittest
import sonarsource_task3 as dt

class TestSonarTask3(unittest.TestCase):
  def test_solution_ex1(self):
    S = "id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7"
    C = "age"
    self.assertEqual(68, dt.solution(S, C))

  def test_solution_ex1_neg(self):
    S = "id,name,age,act.,room,dep.\n1,Jack,-68,T,13,8\n17,Betty,28,F,15,7"
    C = "age"
    self.assertEqual(28, dt.solution(S, C))

  def test_solution_ex1_empty_cell(self):
    S = "id,name,age,act.,room,dep.\n1,,68,T,13,8\n17,Betty,28,F,15,7"
    C = "age"
    self.assertEqual(68, dt.solution(S, C))

if __name__=='__main__':
  unittest.main()