package site.metacoding.animalprojectfrontend.domain.animals;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimalsRepository extends JpaRepository<Animals, Integer> {

    // 지역별
    // 지역별 조회
    @Query(value = "SELECT * FROM Animals am WHERE careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
    List<Animals> keywordOfRegion(@Param("keywordOfSido") String keywordOfSido,
            @Param("keywordOfSigungu") String keywordOfSigungu);

    // 지역별 조회 시도만
    @Query(value = "SELECT * FROM Animals am WHERE careAddr LIKE %:keywordOfSido% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
    List<Animals> keywordOfRegionSido(@Param("keywordOfSido") String keywordOfSido);

    // 날짜별
    // 날짜별 조회happenDt
    @Query(value = "SELECT * FROM Animals am WHERE noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
    List<Animals> keywordOfDay(@Param("keywordOfirstDate") String keywordOfirstDate,
            @Param("keywordOflastDate") String keywordOflastDate);

    // 품종별
    // 품종별 조회KindCd
    @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
    List<Animals> keywordOfKind(@Param("keywordOfkind") String keywordOfkind,
            @Param("keywordOfkindOf") String keywordOfkindOf);

    // 품종별
    // 품종별 조회 품종만
    @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
    List<Animals> keywordOfKindOnly(@Param("keywordOfkind") String keywordOfkind);

    // 지역별, 날짜별, 품종별 조회
    @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% AND careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% AND noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC;", nativeQuery = true)
    List<Animals> keywordOfAll(@Param("keywordOfkind") String keywordOfkind, @Param("keywordOfkindOf") String keywordOfkindOf, @Param("keywordOfSido") String keywordOfSido, @Param("keywordOfSigungu") String keywordOfSigungu, @Param("keywordOfirstDate") String keywordOfirstDate, @Param("keywordOflastDate") String keywordOflastDate);
}
