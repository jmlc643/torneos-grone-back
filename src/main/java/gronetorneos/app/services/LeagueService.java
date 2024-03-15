package gronetorneos.app.services;

import gronetorneos.app.excepts.ResourceNotExistsException;
import gronetorneos.app.models.League;
import gronetorneos.app.repositories.LeagueRepository;
import gronetorneos.app.serializers.league.LeagueSerializer;
import gronetorneos.app.serializers.league.SaveLeagueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired private LeagueRepository leagueRepository;

    public List<League> listLeagues(){return leagueRepository.findAll();}

    public LeagueSerializer saveLeague(SaveLeagueRequest request){
        League league = new League(null, request.getLeagueName(), request.getPlayersNumber());
        leagueRepository.save(league);
        return returnLeague(league);
    }

    public League findLeague(Long idLeague){
        Optional<League> league = leagueRepository.findById(idLeague);
        if(league.isEmpty()){
            throw new ResourceNotExistsException("The League ID #"+idLeague+" has not been found");
        } return league.get();
    }

    public LeagueSerializer returnLeague(League league){
        return new LeagueSerializer(league.getLeagueName(), league.getPlayersNumber());
    }
}
