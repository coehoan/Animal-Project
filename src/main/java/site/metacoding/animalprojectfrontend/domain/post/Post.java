package site.metacoding.animalprojectfrontend.domain.post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import javax.persistence.PrePersist;

import org.hibernate.annotations.DynamicInsert;
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
@DynamicInsert
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
    @Column(nullable = false)
    private Integer view;

    // 추천수
    @Column(nullable = false)
    private Integer recommended;

    @CreatedDate // insert
    private LocalDateTime createDate;
    @LastModifiedDate // insert, update
    private LocalDateTime updateDate;

    @PrePersist // view, recommended의 값이 null이면 0으로 치환해서 가져옴.
    public void prePersist() {
        this.view = this.view == null ? 0 : this.view;
        this.recommended = this.recommended == null ? 0 : this.recommended;
    }

    public String yyyymmddhhmm() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분");
        return createDate.format(formatter);
    }

    public String yyyymmdd() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createDate.format(formatter);
    }
}
