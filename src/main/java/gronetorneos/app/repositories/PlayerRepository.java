package gronetorneos.app.repositories;

import gronetorneos.app.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    boolean existsPlayerByUsername(String username);

    Optional<Player> findByUsername(String username);
}
