package site.metacoding.animalprojectbackend.animalkind.modeling;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KindRepository extends JpaRepository<KindDto, Integer> {

}
