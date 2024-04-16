package app.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.NamedQueries(
        {@org.hibernate.annotations.NamedQuery(name = "findTennisMatchById", query = "from TennisMatch pers where pers.id = :id"),
                @org.hibernate.annotations.NamedQuery(name = "findAllTennisMatches", query = "SELECT DISTINCT tennisMatch from TennisMatch tennisMatch LEFT JOIN FETCH tennisMatch.referee LEFT JOIN FETCH tennisMatch.tennisPlayer1 LEFT JOIN FETCH tennisMatch.tennisPlayer2"),
                @org.hibernate.annotations.NamedQuery(name = "findAllTennisMatchesByRefereeId", query = "SELECT DISTINCT tennisMatch from TennisMatch tennisMatch LEFT JOIN FETCH tennisMatch.referee WHERE tennisMatch.referee.id= :id "),
                @org.hibernate.annotations.NamedQuery(name = "findAllTennisMatchesByTennisPlayerId", query = "SELECT DISTINCT tennisMatch from TennisMatch tennisMatch LEFT JOIN FETCH tennisMatch.tennisPlayer1 LEFT JOIN FETCH tennisMatch.tennisPlayer2 WHERE tennisMatch.tennisPlayer1.id = :id or tennisMatch.tennisPlayer2.id = :id")
        }
)
public class TennisMatch implements Comparable<TennisMatch>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private TennisPlayer tennisPlayer1;
    @ManyToOne
    private TennisPlayer tennisPlayer2;
    @ManyToOne
    private Referee referee;
    @Column
    private LocalTime time;
    @Column
    private CategoryType category;
    @Column
    private Integer tennisPlayer1Score;
    @Column
    private Integer tennisPlayer2Score;
    @Column
    private Boolean played;

    public TennisMatch(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2, Referee referee, CategoryType category, Boolean matchPlayed) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
        this.referee = referee;
        this.category = category;
        this.played = matchPlayed;
    }

    public TennisMatch(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2, Referee referee, CategoryType category, LocalTime time) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
        this.referee = referee;
        this.time = time;
        this.category = category;
    }

    public TennisMatch(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2, Referee referee, CategoryType category, Integer score1, Integer score2, Boolean matchPlayed) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
        this.referee = referee;
        this.category = category;
        this.played = matchPlayed;
        this.tennisPlayer1Score = score1;
        this.tennisPlayer2Score = score2;
    }

    public TennisMatch(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2, Referee referee, CategoryType category) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
        this.referee = referee;
        this.category = category;
    }

    @Override
    public int compareTo(TennisMatch o) {
        if(this.tennisPlayer1Score != null && this.tennisPlayer2Score != null && o.tennisPlayer1Score != null && o.tennisPlayer2Score != null)
            return Integer.compare(Math.abs(this.tennisPlayer1Score-this.tennisPlayer2Score), Math.abs(o.tennisPlayer1Score-o.tennisPlayer2Score));
        return 0;
    }

    @Override
    public String toString() {
        return "TennisMatch{" +
                "id=" + id +
                ", tennisPlayer1=" + tennisPlayer1 +
                ", tennisPlayer2=" + tennisPlayer2 +
                ", referee=" + referee +
                ", time=" + time +
                ", category=" + category +
                ", tennisPlayer1Score=" + tennisPlayer1Score +
                ", tennisPlayer2Score=" + tennisPlayer2Score +
                ", played=" + played +
                '}';
    }
}
