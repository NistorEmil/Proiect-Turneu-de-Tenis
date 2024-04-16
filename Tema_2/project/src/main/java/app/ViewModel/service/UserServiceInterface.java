package app.ViewModel.service;

import app.model.User;

import java.util.List;

public interface UserServiceInterface {
    User save(User client);

    User update(User client);

    List<User> findAll();

    User findById(Integer id);
    public User findByUsername(String username);

    boolean delete(User client);

    User login(String name, String password);
}
