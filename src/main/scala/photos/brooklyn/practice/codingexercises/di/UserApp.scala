package photos.brooklyn.practice.codingexercises.di

import photos.brooklyn.practice.codingexercises.di.repo.UserRepositoryJDBCTemplateComponent
import photos.brooklyn.practice.codingexercises.di.service.DefaultUserServiceComponent
import photos.brooklyn.practice.codingexercises.jdbc.JdbcTemplate

object UserApp {
  def main(args: Array[String]): Unit = {
    val svcComp = new DefaultUserServiceComponent with UserRepositoryJDBCTemplateComponent{
      override val jdbcTemplate: JdbcTemplate = new JdbcTemplate {
        override def update(str: String): Boolean = true

        override def query[T](sql: String): List[T] = List()
      }
    }
    val svc = svcComp.userService
    print(svc.findAll)
  }
}
