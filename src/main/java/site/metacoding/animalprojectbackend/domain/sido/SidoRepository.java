package site.metacoding.animalprojectbackend.domain.sido;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SidoRepository extends JpaRepository<Sido, Integer> {
    
    @Query(value = "SELECT * FROM Sido WHERE orgCd", nativeQuery = true)
    List<Sido> findCd();

}
