package site.metacoding.animalprojectfrontend.domain.animals;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lombok.RequiredArgsConstructor;

public interface AnimalsRepository extends JpaRepository<Animals, Integer> {

        // JPA에선 rand() 함수 지원X
        // @Query(value = "SELECT filename, age, careNm, sexCd FROM animals ORDER BY
        // RAND() LIMIT 4", nativeQuery = true)
        // List<Animals> findMainAnimals();

        // 지역별
        // 지역별 조회
        @Query(value = "SELECT * FROM animals am WHERE careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfRegion(@Param("keywordOfSido") String keywordOfSido,
                        @Param("keywordOfSigungu") String keywordOfSigungu);

        // 지역별 조회 시도만
        @Query(value = "SELECT * FROM animals am WHERE careAddr LIKE %:keywordOfSido% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfRegionSido(@Param("keywordOfSido") String keywordOfSido);

        // 날짜별
        // 날짜별 조회happenDt
        @Query(value = "SELECT * FROM animals am WHERE noticeSdt BETWEEN :keywordOfirstDate AND :keywordOflastDate GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfDay(@Param("keywordOfirstDate") String keywordOfirstDate,
                        @Param("keywordOflastDate") String keywordOflastDate);

        // 품종별
        // 품종별 조회KindCd
        @Query(value = "SELECT * FROM animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfKind(@Param("keywordOfkind") String keywordOfkind,
                        @Param("keywordOfkindOf") String keywordOfkindOf);

        // 품종별
        // 품종별 조회 품종만
        @Query(value = "SELECT * FROM animals am WHERE KindCd LIKE %:keywordOfkind% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfKindOnly(@Param("keywordOfkind") String keywordOfkind);

        // 지역별, 날짜별, 품종별 조회
        @Query(value = "SELECT * FROM animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% AND careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% AND noticeSdt BETWEEN :keywordOfirstDate AND :keywordOflastDate GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfAll(@Param("keywordOfkind") String keywordOfkind,
                        @Param("keywordOfkindOf") String keywordOfkindOf, @Param("keywordOfSido") String keywordOfSido,
                        @Param("keywordOfSigungu") String keywordOfSigungu,
                        @Param("keywordOfirstDate") String keywordOfirstDate,
                        @Param("keywordOflastDate") String keywordOflastDate);

        ////////////// 유저에게 지역 우선으로 보여주기

        // 전체검색만!!
<<<<<<< HEAD
        @Query(value = "SELECT * FROM animals WHERE orgNm = :userRegion GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DESC", nativeQuery = true)
        List<Animals> forUser(@Param("userRegion") String userRegion);
=======
        @Query(value = "SELECT * FROM Animals GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DESC ORDER BY orgNm = :userRegion DESC", nativeQuery = true)

>>>>>>> 851a3b1585c9064b90a12e414a040ac21e11b034

}
