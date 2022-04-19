package site.metacoding.animalprojectfrontend.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 300, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    // 게시판
    @Column(length = 30, nullable = false)
    private String board;

    // 지역
    @Column(length = 15, nullable = true)
    private String region;

    // 동물종류
    @Column(length = 15, nullable = true)
    private String type;

    // 지역별 게시판 카테고리
    @Column(length = 15, nullable = true)
    private String category;

    // 조회수
    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer view;

    // 추천수
    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer recommended;

    @CreatedDate // insert
    private LocalDateTime createDate;
    @LastModifiedDate // insert, update
    private LocalDateTime updateDate;
}
