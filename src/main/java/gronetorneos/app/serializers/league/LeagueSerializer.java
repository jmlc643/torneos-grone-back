package gronetorneos.app.serializers.league;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeagueSerializer {
    private String leagueName;
    private int playersNumber;
}
