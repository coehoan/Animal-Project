package site.metacoding.animalprojectfrontend.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM User WHERE username=:username AND password=:password", nativeQuery = true)
    User aLogin(@Param("username") String username, @Param("password") String password);
}
