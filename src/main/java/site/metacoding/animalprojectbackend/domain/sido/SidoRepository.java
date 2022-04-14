package site.metacoding.animalprojectbackend.domain.sido;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SidoRepository extends JpaRepository<Sido, Integer> {
    
<<<<<<< HEAD
    @Query(value = "SELECT * FROM Sido WHERE orgCd", nativeQuery = true)
    List<Sido> findCd();
=======
    @Query(value = "SELECT * FROM SidoDto WHERE orgCd", nativeQuery = true)
    List<SidoDto> findCd();

    @Query(value = "SELECT * FROM SidoDto WHERE orgCd", nativeQuery = true)
    Set<SidoDto> findCdHash();
>>>>>>> e21804325a7de08ba7ba48eea59beaed37b53497

}
