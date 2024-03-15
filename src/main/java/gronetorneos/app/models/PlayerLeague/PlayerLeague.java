package gronetorneos.app.models.PlayerLeague;

import gronetorneos.app.models.League;
import gronetorneos.app.models.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "player_league")
@IdClass(value = PlayerLeaguePK.class)
@Entity
@NoArgsConstructor
public class PlayerLeague {

    @Id
    @JoinColumns({
            @JoinColumn(name = "username", referencedColumnName = "username")
    })
    @OneToOne
    private Player player;

    @Id
    @JoinColumns({
            @JoinColumn(name = "id_league", referencedColumnName = "id_league")
    })
    @OneToOne
    private League league;

    @Column(name = "points", nullable = false)
    private int points;
    @Column(name = "percent_for", nullable = false)
    private double percentFor;
    @Column(name = "percent_against", nullable = false)
    private double percentAgainst;
    @Column(name = "percent_difference", nullable = false)
    private double percentDifference;
    @Column(name = "won", nullable = false)
    private int won;
    @Column(name = "drawn", nullable = false)
    private int drawn;
    @Column(name = "lost", nullable = false)
    private int lost;

    public PlayerLeague(Player player, League league){
        this.player = player;
        this.league = league;
        points = calculatePoints();
        percentFor = 0;
        percentAgainst = 0;
        percentDifference = calculatePercentDifference();
        won = 0;
        drawn = 0;
        lost = 0;
    }

    public double calculatePercentDifference(){ return percentFor - percentAgainst;}

    public int calculatePoints(){return 3 * won + drawn;}
}
