package ITksiki.TalantDemo.service.impl;


import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.repository.EventRepository;
import ITksiki.TalantDemo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
}