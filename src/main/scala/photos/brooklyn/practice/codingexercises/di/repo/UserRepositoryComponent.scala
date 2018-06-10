package photos.brooklyn.practice.codingexercises.di.repo

import photos.brooklyn.practice.codingexercises.di.model.User

trait UserRepositoryComponent {
  def userRepository: UserRepository

  trait UserRepository{
    def findAll: List[User]
    def update(user: User): Boolean
  }

}
