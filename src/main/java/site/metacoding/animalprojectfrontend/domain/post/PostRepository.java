package site.metacoding.animalprojectfrontend.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM post WHERE board=:board", nativeQuery = true)
    List<Post> findByBoard(@Param("board") String board);

}
