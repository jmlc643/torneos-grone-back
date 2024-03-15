package gronetorneos.app.models.PlayerLeague;

import gronetorneos.app.models.League;
import gronetorneos.app.models.Player;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerLeaguePK implements Serializable {

    @JoinColumns({
            @JoinColumn(name = "username", referencedColumnName = "username")
    })
    @OneToOne
    private Player player;

    @JoinColumns({
            @JoinColumn(name = "id_league", referencedColumnName = "id_league")
    })
    @OneToOne
    private League league;
}
