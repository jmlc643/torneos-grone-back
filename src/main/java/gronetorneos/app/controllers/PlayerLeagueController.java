package gronetorneos.app.controllers;

import gronetorneos.app.serializers.player_league.PlayerLeagueSerializer;
import gronetorneos.app.serializers.player_league.SavePlayerLeagueRequest;
import gronetorneos.app.services.PlayerLeagueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player-league")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerLeagueController {

    @Autowired private PlayerLeagueService playerLeagueService;

    @GetMapping("/list/")
    public List<PlayerLeagueSerializer> listPlayersLeague(){
        return playerLeagueService.listPlayersLeague().stream().map((it) -> playerLeagueService.returnPlayerLeague(it)).toList();
    }

    @PostMapping("/save/")
    public PlayerLeagueSerializer savePlayerLeague(@Valid @RequestBody SavePlayerLeagueRequest request){
        return playerLeagueService.savePlayerLeague(request);
    }
}
