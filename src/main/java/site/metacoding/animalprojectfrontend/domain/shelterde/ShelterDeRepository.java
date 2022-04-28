package site.metacoding.animalprojectfrontend.domain.shelterde;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShelterDeRepository extends JpaRepository<ShelterDe, Integer> {

    @Query(value = "SELECT * FROM Shelterde WHERE orgNm =:addr", nativeQuery = true)
    List<ShelterDe> findByAddr(@Param("addr") String addr);

    @Query(value = "SELECT * FROM Shelterde WHERE saveTrgtAnimal LIKE %:kind%", nativeQuery = true)
    List<ShelterDe> findByKind(@Param("kind") String kind);

    @Query(value = "SELECT * FROM Shelterde WHERE orgNm =:addr AND saveTrgtAnimal LIKE %:kind%", nativeQuery = true)
    List<ShelterDe> findByAddrAndKind(@Param("addr") String addr, @Param("kind") String kind);
}
