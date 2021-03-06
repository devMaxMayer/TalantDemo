package ITksiki.TalantDemo.repository;

import ITksiki.TalantDemo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByName(String name);
}
