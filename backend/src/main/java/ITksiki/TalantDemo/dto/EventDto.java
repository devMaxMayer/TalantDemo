package ITksiki.TalantDemo.dto;

import ITksiki.TalantDemo.entity.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {
    private String name;
    private String status;

    public Event toEvent() {
        Event event = new Event();
        event.setName(name);
        event.setStatus(status);

        return event;
    }

    public static EventDto fromEvent(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setName(event.getName());
        eventDto.setStatus(event.getStatus());

        return eventDto;
    }
}
