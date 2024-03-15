package gronetorneos.app.controllers;

import gronetorneos.app.models.Player;
import gronetorneos.app.serializers.player.PlayerSerializer;
import gronetorneos.app.serializers.player.SavePlayerRequest;
import gronetorneos.app.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    @Autowired private PlayerService playerService;

    @GetMapping("/list/")
    public List<PlayerSerializer> listPlayers(){
        return playerService.listPlayers().stream().map((it) -> playerService.returnPlayer(it)).toList();
    }

    @PostMapping("/save/")
    public PlayerSerializer savePlayer(@Valid @RequestBody SavePlayerRequest request){
        return playerService.savePlayer(request);
    }
}
