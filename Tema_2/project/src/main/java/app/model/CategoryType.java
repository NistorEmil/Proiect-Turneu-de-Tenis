package app.model;

public enum CategoryType {
    MALE,
    FEMALE,
    UNDER18;

    @Override
    public String toString() {
        if (this.equals(MALE))
            return "MALE";
        else if(this.equals(FEMALE))
            return "FEMALE";
        else return "UNDER18";
    }
}
