package app.ViewModel.service.implementation;

import app.model.Person;
import app.model.Referee;
import app.model.User;
import app.ViewModel.service.UserRefereeServiceInterface;
import app.model.repository.RefereeRepositoryInterface;
import app.model.repository.UserRepositoryInterface;
import app.ViewModel.single_point_access.RepositorySinglePointAccess;
import org.springframework.stereotype.Service;

@Service
public class UserRefereeService implements UserRefereeServiceInterface {

    private final RefereeRepositoryInterface refereeRepository = RepositorySinglePointAccess.getRefereeRepository();
    private final UserRepositoryInterface userRepository = RepositorySinglePointAccess.getUserRepository();

    @Override
    public void associateUserWithReferee(User user, Referee referee) {
        // Asocierea utilizatorului cu arbitru
        referee.setAssociatedUser(user);
        user.setAssociatedPerson(referee);
        refereeRepository.save(referee);
        userRepository.update(user);
    }

    @Override
    public Referee getRefereeByUser(User user) {
        // Obținerea arbitrului asociat unui utilizator
        return refereeRepository.findRefereeByAssociatedUser(user);
    }
    @Override
    public User getUserByPerson(Person person) {
        // Obținerea arbitrului asociat unui utilizator
        return userRepository.findUserByAssociatedPerson(person);
    }

}