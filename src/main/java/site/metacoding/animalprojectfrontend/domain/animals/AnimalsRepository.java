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
        @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% AND careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% AND noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC", nativeQuery = true)
        List<Animals> keywordOfAll(@Param("keywordOfkind") String keywordOfkind,
                        @Param("keywordOfkindOf") String keywordOfkindOf, @Param("keywordOfSido") String keywordOfSido,
                        @Param("keywordOfSigungu") String keywordOfSigungu,
                        @Param("keywordOfirstDate") String keywordOfirstDate,
                        @Param("keywordOflastDate") String keywordOflastDate);

        ////////////// 유저에게 지역 우선으로 보여주기

        // 지역검색
        @Query(value = "SELECT * FROM Animals am WHERE careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserRegion(@Param("keywordOfSido") String keywordOfSido,
                        @Param("keywordOfSigungu") String keywordOfSigungu, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);

        // 지역검색 시도만
        @Query(value = "SELECT * FROM Animals am WHERE careAddr LIKE %:keywordOfSido% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserSido(@Param("keywordOfSido") String keywordOfSido, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);

        // 날짜검색
        @Query(value = "SELECT * FROM Animals am WHERE noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserDay(@Param("keywordOfirstDate") String keywordOfirstDate,
                        @Param("keywordOflastDate") String keywordOflastDate, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);

        // 품종별
        // 품종별 조회KindCd
        @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserKind(@Param("keywordOfkind") String keywordOfkind,
                        @Param("keywordOfkindOf") String keywordOfkindOf, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);

        // 품종별
        // 품종별 조회 품종만
        @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserKindOf(@Param("keywordOfkind") String keywordOfkind, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);

        // 지역별, 날짜별, 품종별 조회
        @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% AND careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% AND noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% UNION ALL SELECT * FROM Animals am WHERE orgNm IN(SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when orgNm = ':addrSido + :addrSigungu' then 1 ELSE 2 END", nativeQuery = true)
        List<Animals> forUserAll(@Param("keywordOfkind") String keywordOfkind,
                        @Param("keywordOfkindOf") String keywordOfkindOf, @Param("keywordOfSido") String keywordOfSido,
                        @Param("keywordOfSigungu") String keywordOfSigungu,
                        @Param("keywordOfirstDate") String keywordOfirstDate,
                        @Param("keywordOflastDate") String keywordOflastDate, @Param("id") String id, @Param("addrSido") String addrSido, @Param("addrSigungu") String addrSigungu);
}
