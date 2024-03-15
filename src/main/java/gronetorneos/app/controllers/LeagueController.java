package gronetorneos.app.controllers;

import gronetorneos.app.serializers.league.LeagueSerializer;
import gronetorneos.app.serializers.league.SaveLeagueRequest;
import gronetorneos.app.services.LeagueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("league")
@CrossOrigin(origins = "http://localhost:4200")
public class LeagueController {

    @Autowired private LeagueService leagueService;

    @GetMapping("/list/")
    public List<LeagueSerializer> listLeagues(){
        return leagueService.listLeagues().stream().map((it) -> leagueService.returnLeague(it)).toList();
    }

    @PostMapping("/save/")
    public LeagueSerializer saveLeague(@Valid @RequestBody SaveLeagueRequest request){
        return leagueService.saveLeague(request);
    }
}
