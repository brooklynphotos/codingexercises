package photos.brooklyn.practice.codingexercises.di.service

import photos.brooklyn.practice.codingexercises.di.model.User
import photos.brooklyn.practice.codingexercises.di.repo.UserRepositoryComponent

trait DefaultUserServiceComponent extends UserServiceComponent{
  this: UserRepositoryComponent =>

  override def userService: UserService = new DefaultUserService

  class DefaultUserService extends UserService {
    override def findAll = userRepository.findAll

    override def save(user: User) = userRepository.update(user)
  }
}
