package photos.brooklyn.practice.codingexercises.di.service

import photos.brooklyn.practice.codingexercises.di.model.User

trait UserServiceComponent {
  def userService: UserService

  trait UserService{
    def findAll: List[User]
    def save(user: User): Boolean
  }

}
