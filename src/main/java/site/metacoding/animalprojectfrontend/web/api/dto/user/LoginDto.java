package site.metacoding.animalprojectfrontend.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {
    private Integer id;
    private String addrSido;
    private String addrSigungu;
    private String username;
    private String password;
    private String remember;

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setAddrSido(this.addrSido);
        user.setAddrSigungu(this.addrSigungu);
        return user;
    }
}
