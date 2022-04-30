package site.metacoding.animalprojectfrontend.domain.shelterde;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShelterDeRepository extends JpaRepository<ShelterDe, Integer> {

    @Query(value = "SELECT * FROM Shelterde WHERE orgNm =:addr", nativeQuery = true)
    Page<ShelterDe> findByAddr(@Param("addr") String addr, Pageable pr);

    @Query(value = "SELECT * FROM Shelterde WHERE saveTrgtAnimal LIKE %:kind%", nativeQuery = true)
    Page<ShelterDe> findByKind(@Param("kind") String kind, Pageable pr);

    @Query(value = "SELECT * FROM Shelterde WHERE orgNm =:addr AND saveTrgtAnimal LIKE %:kind%", nativeQuery = true)
    Page<ShelterDe> findByAddrAndKind(@Param("addr") String addr, @Param("kind") String kind, Pageable pr);
}
