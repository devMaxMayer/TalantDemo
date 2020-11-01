package ITksiki.TalantDemo.repository;

import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.entity.User;
import ITksiki.TalantDemo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);

    //Set<User> findByEvent(Event event);

    @Modifying
    @Query(nativeQuery = true, value = "update user set status = :status where id = :id")
    void disableById(@Param("id") Long id, @Param("status") Status status);
}
