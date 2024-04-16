package app.view;

import app.model.UserType;

public interface LoginInterface {
    String getUserName();
    String getPassword();
    UserType getRole();
}

