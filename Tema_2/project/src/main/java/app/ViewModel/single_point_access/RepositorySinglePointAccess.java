package app.ViewModel.single_point_access;

import app.model.repository.RefereeRepositoryInterface;
import app.model.repository.TennisMatchRepositoryInterface;
import app.model.repository.TennisPlayerRepositoryInterface;
import app.model.repository.UserRepositoryInterface;
import app.model.repository.implementation.RefereeRepository;
import app.model.repository.implementation.TennisMatchRepository;
import app.model.repository.implementation.TennisPlayerRepository;
import app.model.repository.implementation.UserRepository;

public class RepositorySinglePointAccess {

    private static TennisPlayerRepositoryInterface tennisPlayerRepository;
    private static UserRepositoryInterface userRepository;
    private static RefereeRepositoryInterface refereeRepository;
    private static TennisMatchRepositoryInterface tennisMatchRepository;

    static {
        userRepository = new UserRepository();
        tennisPlayerRepository = new TennisPlayerRepository();
        refereeRepository = new RefereeRepository();
        tennisMatchRepository = new TennisMatchRepository();
    }


    public static UserRepositoryInterface getUserRepository() { return userRepository; }
    public static TennisPlayerRepositoryInterface getTennisPlayerRepository() { return tennisPlayerRepository; }
    public static RefereeRepositoryInterface getRefereeRepository() { return refereeRepository; }
    public static TennisMatchRepositoryInterface getTennisMatchRepository() { return tennisMatchRepository; }
}
