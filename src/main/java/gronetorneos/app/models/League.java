package gronetorneos.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "leagues")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_league")
    private Long idLeague;
    @Column(name = "league_name", nullable = false)
    private String leagueName;
    @Column(name = "players_number", nullable = false)
    private int playersNumber;
}
