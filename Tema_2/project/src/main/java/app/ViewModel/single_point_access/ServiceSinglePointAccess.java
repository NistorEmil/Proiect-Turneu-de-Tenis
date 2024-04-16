package app.ViewModel.single_point_access;

import app.ViewModel.service.*;
import app.ViewModel.service.implementation.*;

public class ServiceSinglePointAccess {

    private static UserServiceInterface userService;
    private static TennisPlayerServiceInterface tennisPlayerService;
    private static RefereeServiceInterface refereeService;
    private static TennisMatchServiceInterface tennisMatchService;
    private static UserRefereeServiceInterface userRefereeService;

    static {
        userService = new UserService();
    }

    static {
        tennisPlayerService = new TennisPlayerService();
    }

    static {
        refereeService = new RefereeService();
    }

    static {
        tennisMatchService = new TennisMatchService();
    }

    static {
        userRefereeService = new UserRefereeService();
    }

    public static UserServiceInterface getUserService() { return userService; }
    public static TennisPlayerServiceInterface getTennisPlayerService() { return tennisPlayerService; }
    public static RefereeServiceInterface getRefereeService() { return refereeService; }
    public static TennisMatchServiceInterface getTennisMatchService() { return tennisMatchService; }
    public static UserRefereeServiceInterface getUserRefereeService() { return userRefereeService; }

}
