package photos.brooklyn.practice.codingexercises.jdbc

trait JdbcTemplate {
  def update(str: String): Boolean

  def query[T](sql: String): List[T]
}
