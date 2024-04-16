package app.view;

import app.model.CategoryType;
import app.model.UserType;

public interface TennisMatchInterface {
    String getId();
    String getTennisPlayer1Id();
    String getTennisPlayer2Id();
    String getRefereeId();
    CategoryType getCategory();
}
