package site.metacoding.animalprojectfrontend.domain.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM post WHERE board =:board", nativeQuery = true)
    Page<Post> findByBoard(@Param("board") String board, Pageable page);

    @Query(value = "SELECT * FROM post WHERE board =:board ORDER BY view DESC LIMIT 3", nativeQuery = true)
    List<Post> findHotPost(@Param("board") String board);

    @Query(value = "UPDATE post SET view =:view WHERE id =:id", nativeQuery = true)
    Post viewCount(@Param("view") Integer view, @Param("id") Integer id);

    @Query(value = "UPDATE post SET recommended =:recommended WHERE id =:id", nativeQuery = true)
    Post recCount(@Param("recommended") Integer recommended, @Param("id") Integer id);

    @Query(value = "SELECT * FROM post WHERE board =:board AND region =:region ORDER BY id DESC", nativeQuery = true)
    Page<Post> findByBoardAndRegion(@Param("board") String board, @Param("region") String region, Pageable page);

    @Query(value = "SELECT * FROM post WHERE board =:board AND type =:type ORDER BY id DESC", nativeQuery = true)
    Page<Post> findByBoardAndType(@Param("board") String board, @Param("type") String type, Pageable page);

    @Query(value = "SELECT * FROM post WHERE board =:board AND region =:region AND type =:type ORDER BY id DESC", nativeQuery = true)
    Page<Post> findByBoardAndRegionANDType(@Param("board") String board, @Param("region") String region,
            @Param("type") String type, Pageable page);

    @Query(value = "SELECT * FROM post WHERE board =:board AND searchBy =:searchBy LIKE %query =:query%", nativeQuery = true)
    Page<Post> findByBoardSearchBy(@Param("board") String board, @Param("searchBy") String searchBy,
            @Param("query") String query, Pageable page);

}
