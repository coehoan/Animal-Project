package site.metacoding.animalprojectbackend.domain.animals;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalsRepository extends JpaRepository<Animals, Integer> {
    
}
