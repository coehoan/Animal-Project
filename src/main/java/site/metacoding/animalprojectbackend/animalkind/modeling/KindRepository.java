package site.metacoding.animalprojectbackend.animalkind.modeling;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KindRepository extends JpaRepository<Kind, Integer> {
    @Query(value = "SELECT * FROM KindDto WHERE kindCd", nativeQuery = true)
    List<KindDto> findKindCd();
}
