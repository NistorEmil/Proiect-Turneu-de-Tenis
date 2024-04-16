package app.ViewModel.service.implementation;

import app.model.User;
import app.ViewModel.service.UserServiceInterface;
import app.model.repository.UserRepositoryInterface;
import app.ViewModel.single_point_access.RepositorySinglePointAccess;

import java.util.List;

public class UserService implements UserServiceInterface {

    private UserRepositoryInterface userRepository = RepositorySinglePointAccess.getUserRepository();

    @Override
    public User save(User client) {
        return userRepository.save(client);
    }

    @Override
    public User update(User client) {
        return userRepository.update(client);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public boolean delete(User utilizator) {
        return userRepository.delete(utilizator);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findUserByUsername(username);
    }
}
