package app.model.repository;

import app.model.Person;
import app.model.User;

public interface UserRepositoryInterface extends CRUDRepository<User, Integer>  {
    User findUserByUsername(String username);

    User findUserByAssociatedPerson(Person person);
}
