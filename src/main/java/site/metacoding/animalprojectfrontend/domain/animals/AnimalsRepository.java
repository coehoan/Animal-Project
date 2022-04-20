package site.metacoding.animalprojectfrontend.domain.animals;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimalsRepository extends JpaRepository<Animals, Integer> {
    // 지역별 조회
    @Query(value = "SELECT * FROM Animals am WHERE careAddr LIKE %:keywordOfSido% OR :keywordOfSigungu", nativeQuery = true)
    List<Animals> keywordOfRegion(@Param("keywordOfSido") String keywordOfSido, @Param("keywordOfSigungu") String keywordOfSigungu);

    // 날짜별 조회
    @Query(value = "SELECT * FROM Animals am WHERE happenDt LIKE %:keywordOfDay%", nativeQuery = true)
    List<Animals> keywordOfDay(@Param("keywordOfDay") String keywordOfDay);
    
    // 품종별 조회
    @Query(value = "SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfKind%", nativeQuery = true)
    List<Animals> keywordOfKind(@Param("keywordOfKind") String keywordOfKind);

    // 지역별, 날짜별, 품종별 조회
    @Query(value = "SELECT * FROM Animals am WHERE careAddr OR happenDt OR KindCd LIKE %:keywordOfAll%", nativeQuery = true)
    List<Animals> keywordOfAll(@Param("keywordOfAll") String keywordOfAll);
}
