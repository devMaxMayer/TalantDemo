package ITksiki.TalantDemo.controller;

import ITksiki.TalantDemo.dto.EventDto;
import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.entity.User;
import ITksiki.TalantDemo.service.EventService;
import ITksiki.TalantDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/event/")
public class EventController {

    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping("subscribe-event")
    public Event subscribeEvent(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Event event
    ) {
        return eventService.changeSubscribe(event, user);
    }

    @GetMapping("all-events")
    public List<Event> allEvents() {
        List<Event> events = new ArrayList<>(eventService.findAll());
        return events;
    }

    @GetMapping("my-events")
    public void myEvent() {

    }

    @GetMapping("{id}")
    public ResponseEntity<EventDto> getEventId(@PathVariable(name = "id") Long id) {

        Event event = eventService.findById(id);

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        EventDto result = EventDto.fromEvent(event);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EventDto> deleteById(@PathVariable(name = "id") Long id) {
        Event event = eventService.findById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("add-event")
    public ResponseEntity<Event> addEvent(@RequestBody @Valid Event event) {
        HttpHeaders headers = new HttpHeaders();

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventService.save(event);
        return new ResponseEntity<>(event, headers, HttpStatus.OK);
    }


}