package app.model;

public enum UserType {
    REFEREE,
    TOURNAMENT_ORGANIZER,
    ADMINISTRATOR;

    @Override
    public String toString() {
        if (this.equals(REFEREE))
            return "REFEREE";
        else if(this.equals(TOURNAMENT_ORGANIZER))
            return "TOURNAMENT_ORGANIZER";
        else return "ADMINISTRATOR";
    }
}
