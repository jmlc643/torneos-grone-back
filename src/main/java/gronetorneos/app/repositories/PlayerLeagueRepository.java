package gronetorneos.app.repositories;

import gronetorneos.app.models.League;
import gronetorneos.app.models.Player;
import gronetorneos.app.models.PlayerLeague.PlayerLeague;
import gronetorneos.app.models.PlayerLeague.PlayerLeaguePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerLeagueRepository extends JpaRepository<PlayerLeague, PlayerLeaguePK> {
    boolean existsPlayerLeagueByPlayerAndLeague(Player player, League league);
}
