package site.metacoding.animalprojectfrontend.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // pk

    @Column(unique = true, nullable = false, length = 12)
    private String username;// 회원가입, 로그인

    @Column(nullable = false, length = 12)
    private String password;// 회원가입, 로그인

    @Column(nullable = false, length = 30)
    private String email; // 회원가입

    @Column(nullable = false, length = 30)
    private String male; // 회원가입 성별

    @Column(nullable = false, length = 300)
    private String addrSido; // 이건 필요하려나?

    @Column(nullable = false, length = 300)
    private String addrSigungu; // 이건 필요하려나?

    @CreatedDate
    private LocalDateTime createDate;// DB
    @LastModifiedDate
    private LocalDateTime updateDate;// DB

}
