package miu.edu.lab1.respository;

import miu.edu.lab1.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("SELECT u FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) > :noOfPosts")
    List<User> findUserByPostsGreaterThan(Integer noOfPosts);
}
