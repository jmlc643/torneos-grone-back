package gronetorneos.app.services;

import gronetorneos.app.excepts.ResourceAlreadyExistsException;
import gronetorneos.app.excepts.ResourceNotExistsException;
import gronetorneos.app.models.Player;
import gronetorneos.app.repositories.PlayerRepository;
import gronetorneos.app.serializers.player.PlayerSerializer;
import gronetorneos.app.serializers.player.SavePlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    @Autowired private PlayerRepository playerRepository;

    public List<Player> listPlayers(){ return playerRepository.findAll();}

    public PlayerSerializer savePlayer(SavePlayerRequest request){
        if(playerRepository.existsPlayerByUsername(request.getUsername())){
            throw new ResourceAlreadyExistsException("The player "+request.getUsername()+" exists");
        }
        Player player = new Player(request.getUsername(), request.getNickname(), request.getProfilePhoto());
        playerRepository.save(player);
        return returnPlayer(player);
    }

    public Player findPlayer(String username){
        Optional<Player> player = playerRepository.findByUsername(username);
        if(player.isEmpty()){
            throw new ResourceNotExistsException("The player "+username+" has not been found");
        } return player.get();
    }

    public PlayerSerializer returnPlayer(Player player){
        return new PlayerSerializer(player.getUsername(), player.getNickname(), player.getProfilePhoto());
    }
}
