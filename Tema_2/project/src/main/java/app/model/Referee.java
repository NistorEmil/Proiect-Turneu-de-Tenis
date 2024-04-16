package app.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.NamedQueries(
        {@org.hibernate.annotations.NamedQuery(name = "findRefereeById", query = "SELECT referee FROM Referee referee WHERE referee.id = :id"),
                @org.hibernate.annotations.NamedQuery(name = "findByRefereeById", query = "SELECT DISTINCT referee from Referee referee LEFT JOIN FETCH referee.tennisMatches where referee.id = :id"),
                @org.hibernate.annotations.NamedQuery(name = "findAllReferees", query = "SELECT DISTINCT referee from Referee referee"),
                @org.hibernate.annotations.NamedQuery(name = "findRefereeByAssociatedUser", query = "SELECT referee from Referee referee where referee.associatedUser = :user")
        }
)
public class Referee extends Person {
    @OneToMany(fetch = FetchType.EAGER)
    private List<TennisMatch> tennisMatches;

    public Referee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Referee(String firstName, String lastName, Integer id) {
        super(id, firstName, lastName);
    }
}
