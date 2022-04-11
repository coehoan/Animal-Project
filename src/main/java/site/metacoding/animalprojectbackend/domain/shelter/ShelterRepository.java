package site.metacoding.animalprojectbackend.domain.shelter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.metacoding.animalprojectbackend.domain.sigungu.SigunguDto;

public interface ShelterRepository extends JpaRepository<ShelterDto, Integer>{
    
    @Query(value = "SELECT sg.id, sg.uprCd, sg.orgCd, sg.orgdownNm FROM SidoDto sd INNER JOIN SigunguDto sg ON sd.orgCd = sg.orgdownNm", nativeQuery = true)
    List<SigunguDto> findShelter();
    
}
