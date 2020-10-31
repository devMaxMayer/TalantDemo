package ITksiki.TalantDemo.service;


import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.entity.User;

import java.util.List;

public interface EventService {
    List<Event> findAll();

    Event findById(Long id);

    Event save (Event event);

    void deleteById(Long id);

    Event ChangeSubscription (Event event, User user);

}
