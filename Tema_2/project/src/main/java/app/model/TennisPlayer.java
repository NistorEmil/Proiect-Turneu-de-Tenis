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
        {@org.hibernate.annotations.NamedQuery(name = "findTennisPlayerById", query = "SELECT DISTINCT tennisPlayer from TennisPlayer tennisPlayer LEFT JOIN FETCH tennisPlayer.tennisMatches where tennisPlayer.id = :id"),
                @org.hibernate.annotations.NamedQuery(name = "findAllTennisPlayers", query = "SELECT DISTINCT tennisPlayer from TennisPlayer tennisPlayer LEFT JOIN FETCH tennisPlayer.tennisMatches")
        }
)
public class TennisPlayer extends Person{
    @Column
    private Integer age;
    @Column
    private String category;
    @OneToMany
    private List<TennisMatch> tennisMatches;

    public TennisPlayer(String firstName, String lastName, Integer age, String category) {
        super(firstName, lastName);
        this.age = age;
        this.category = category;
    }

    public TennisPlayer(String firstName, String lastName, Integer age, String category, List<TennisMatch> tennisMatches) {
        super(firstName, lastName);
        this.age = age;
        this.category = category;
        this.tennisMatches = tennisMatches;
    }
}
