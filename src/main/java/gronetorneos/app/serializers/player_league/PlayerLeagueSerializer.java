package gronetorneos.app.serializers.player_league;


import gronetorneos.app.serializers.league.LeagueSerializer;
import gronetorneos.app.serializers.player.PlayerSerializer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerLeagueSerializer {

    private PlayerSerializer player;
    private LeagueSerializer league;
    private int points;
    private double percentFor;
    private double percentAgainst;
    private double percentDifference;
    private int won;
    private int drawn;
    private int lost;

}
