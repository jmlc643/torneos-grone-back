package gronetorneos.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "players", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Entity
@NoArgsConstructor
public class Player {

    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "profile_photo", nullable = false, columnDefinition = "text")
    private String profilePhoto;

    public Player(String username, String nickname, String profilePhoto){
        this.username = username;
        this.nickname = nickname;
        this.profilePhoto = profilePhoto;
    }
}
