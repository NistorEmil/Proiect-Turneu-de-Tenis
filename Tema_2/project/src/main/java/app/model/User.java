package app.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "findUserById", query = "from User pers where pers.id = :id"),
        @org.hibernate.annotations.NamedQuery(name = "findAllUsers", query = "from User"),
        @org.hibernate.annotations.NamedQuery(name = "findUserByUsername", query = "from User pers where pers.userName = :userName"),
        @org.hibernate.annotations.NamedQuery(name = "findUserByAssociatedPerson", query = "SELECT user from User user where user.associatedPerson = :person")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private UserType role;
    @OneToOne
    private Person associatedPerson;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, UserType role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
