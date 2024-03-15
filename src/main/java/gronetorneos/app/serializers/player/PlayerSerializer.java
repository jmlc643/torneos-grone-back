package gronetorneos.app.serializers.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerSerializer {
    private String username;
    private String nickname;
    private String profilePhoto;
}
