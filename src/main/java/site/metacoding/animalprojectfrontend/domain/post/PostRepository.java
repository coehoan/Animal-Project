package site.metacoding.animalprojectfrontend.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM post WHERE board=:board", nativeQuery = true)
    List<Post> findByBoard(@Param("board") String board);

    @Query(value = "SELECT * FROM post WHERE board =:board ORDER BY view DESC LIMIT 3", nativeQuery = true)
    List<Post> findHotPost(@Param("board") String board);

    @Query(value = "UPDATE post SET view =:view WHERE id =:id", nativeQuery = true)
    Post viewCount(@Param("view") Integer view, @Param("id") Integer id);

    @Query(value = "UPDATE post SET recommended =:recommended WHERE id =:id", nativeQuery = true)
    Post recCount(@Param("recommended") Integer recommended, @Param("id") Integer id);

}
