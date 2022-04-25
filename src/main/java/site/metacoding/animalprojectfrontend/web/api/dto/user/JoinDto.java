package site.metacoding.animalprojectfrontend.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String male;
    private String addrSido;
    private String addrSigungu;

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setMale(this.male);
        user.setAddrSido(this.addrSido);
        user.setAddrSigungu(this.addrSigungu);
        return user;
    }
}
