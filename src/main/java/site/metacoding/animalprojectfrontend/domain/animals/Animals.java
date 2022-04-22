package site.metacoding.animalprojectfrontend.domain.animals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Animals {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 500)
    private String filename; // 썸네일

    @Column(nullable = true, length = 500)
    private String desertionNo; // 유기번호

    @Column(nullable = true, length = 500)
    private String happenDt; // 접수일

    @Column(nullable = true, length = 500)
    private String happenPlace; // 발견장소

    @Column(nullable = true, length = 500)
    private String kindCd; // 품종

    @Column(nullable = true, length = 500)
    private String colorCd; // 색상

    @Column(nullable = true, length = 500)
    private String age; // 나이

    @Column(nullable = true, length = 500)
    private String weight; // 체중

    @Column(nullable = true, length = 500)
    private String noticeNo; // 공고번호

    @Column(nullable = true, length = 500)
    private String noticeSdt; // 공고 시작일

    @Column(nullable = true, length = 500)
    private String noticeEdt; // 공고 종료일

    @Column(nullable = true, length = 500)
    private String popfile; // 이미지

    @Column(nullable = true, length = 500)
    private String processState; // 상태

    @Column(nullable = true, length = 500)
    private String sexCd; // 성별

    @Column(nullable = true, length = 500)
    private String neuterYn; // 중성화 여부

    @Column(nullable = true, length = 500)
    private String specialMark; // 특징

    @Column(nullable = true, length = 500)
    private String careNm; // 보호소 이름

    @Column(nullable = true, length = 500)
    private String careTel; // 보호소 전화번호

    @Column(nullable = true, length = 500)
    private String careAddr; // 보호장소

    @Column(nullable = true, length = 500)
    private String orgNm; // 관활기관

    @Column(nullable = true, length = 500)
    private String chargeNm; // 담당자

    @Column(nullable = true, length = 500)
    private String officetel; // 담당자 연락처

    @Column(nullable = true, length = 500)
    private String noticeComment; // 특이사항

}
