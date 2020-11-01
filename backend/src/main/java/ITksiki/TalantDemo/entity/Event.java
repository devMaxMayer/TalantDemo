package ITksiki.TalantDemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "event", schema = "public", catalog = "talant")
public class Event extends BaseEntity {
    private String name;
    private String status;
    private EventType eventType;
    private Set<User> users;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "id_event_type", referencedColumnName = "id", nullable = false)
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventTypeByIdEventType) {
        this.eventType = eventTypeByIdEventType;
    }

    @ManyToMany (mappedBy = "events", fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
