package app.ViewModel.service;

import app.model.Person;
import app.model.Referee;
import app.model.User;

public interface UserRefereeServiceInterface {
    void associateUserWithReferee(User user, Referee referee);
    Referee getRefereeByUser(User user);
    User getUserByPerson(Person person);
}