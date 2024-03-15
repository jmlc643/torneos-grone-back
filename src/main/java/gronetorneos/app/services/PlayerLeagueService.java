package gronetorneos.app.services;

import gronetorneos.app.excepts.ResourceAlreadyExistsException;
import gronetorneos.app.models.League;
import gronetorneos.app.models.Player;
import gronetorneos.app.models.PlayerLeague.PlayerLeague;
import gronetorneos.app.repositories.PlayerLeagueRepository;
import gronetorneos.app.serializers.player_league.PlayerLeagueSerializer;
import gronetorneos.app.serializers.player_league.SavePlayerLeagueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerLeagueService {

    @Autowired private PlayerLeagueRepository playerLeagueRepository;
    @Autowired private PlayerService playerService;
    @Autowired private LeagueService leagueService;

    public List<PlayerLeague> listPlayersLeague(){return playerLeagueRepository.findAll();}

    public PlayerLeagueSerializer savePlayerLeague(SavePlayerLeagueRequest request){
        Player player = playerService.findPlayer(request.getUsername());
        League league = leagueService.findLeague(request.getIdLeague());
        if(playerLeagueRepository.existsPlayerLeagueByPlayerAndLeague(player, league)){
            throw new ResourceAlreadyExistsException("Error");
        }
        PlayerLeague playerLeague = new PlayerLeague(player, league);
        playerLeagueRepository.save(playerLeague);
        return returnPlayerLeague(playerLeague);
    }

    public PlayerLeagueSerializer returnPlayerLeague(PlayerLeague playerLeague){
        return new PlayerLeagueSerializer(playerService.returnPlayer(playerLeague.getPlayer()), leagueService.returnLeague(playerLeague.getLeague()),
                playerLeague.getPoints(), playerLeague.getPercentFor(), playerLeague.getPercentAgainst(),
                playerLeague.calculatePercentDifference(), playerLeague.getWon(), playerLeague.getDrawn(), playerLeague.getLost());
    }

}
