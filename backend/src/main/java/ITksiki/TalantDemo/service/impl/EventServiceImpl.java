package ITksiki.TalantDemo.service.impl;


import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.entity.User;
import ITksiki.TalantDemo.repository.EventRepository;
import ITksiki.TalantDemo.repository.UserRepository;
import ITksiki.TalantDemo.service.EventService;
import ITksiki.TalantDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    @Autowired
    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Event> findAll() {
        List<Event> eventList = new ArrayList<>();
        List<Event> list;
        list = eventRepository.findAll();
        eventList.addAll(list);
        return eventList;
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event changeSubscribe(Event event, User user) {
        Set<Event> events = user.getEvents();

        if (events.contains(event)){
            events.remove(event);
        }else {
            events.add(event);
        }
        return eventRepository.save(event);
    }
//
//    @Override
//    public Set<User> getSubscribers(Event event) {
//        return userRepository.findByEvent(event);
//    }


}