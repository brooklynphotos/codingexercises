package photos.brooklyn.practice.codingexercises.di.repo
import photos.brooklyn.practice.codingexercises.di.model.User
import photos.brooklyn.practice.codingexercises.jdbc.JdbcTemplate

trait UserRepositoryJDBCTemplateComponent extends UserRepositoryComponent {
  val jdbcTemplate: JdbcTemplate

  override def userRepository: UserRepository = new UserRepositoryJDBC(jdbcTemplate)

  class UserRepositoryJDBC(jdbcTemplate: JdbcTemplate) extends UserRepository {
    override def findAll: List[User] = jdbcTemplate.query("select * from users")

    override def update(user: User): Boolean = jdbcTemplate.update("update users set(?,?)")
  }
}
