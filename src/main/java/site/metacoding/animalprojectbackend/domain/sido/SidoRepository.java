package site.metacoding.animalprojectbackend.domain.sido;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SidoRepository extends JpaRepository<SidoDto, Integer> {
    
    @Query(value = "SELECT * FROM SidoDto WHERE orgCd", nativeQuery = true)
    List<SidoDto> findCd();

    @Query(value = "SELECT * FROM SidoDto WHERE orgCd", nativeQuery = true)
    Set<SidoDto> findCdHash();

}
