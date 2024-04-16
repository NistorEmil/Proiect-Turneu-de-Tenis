package app.view;

import app.model.CategoryType;

import javax.persistence.criteria.CriteriaBuilder;

public interface TennisPlayerInterface {
    String getFirstName();
    String getLastName();
    String getAge();
    CategoryType getCategory();
    String getId();
}
