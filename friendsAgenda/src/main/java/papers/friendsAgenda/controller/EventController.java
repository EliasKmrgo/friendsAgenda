package papers.friendsAgenda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import papers.friendsAgenda.domain.mongo.EventDetail;
import papers.friendsAgenda.service.EventService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // GET /events
    @GetMapping
    public List<EventDetail> getAll() {
        return eventService.getAllEventDetails();
    }

    // GET /events/{id}
    @GetMapping("/{id}")
    public Optional<EventDetail> getById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    // POST /events
    @PostMapping
    public EventDetail createEvent(@RequestBody EventDetail event) {
        return eventService.saveEventDetail(event);
    }

    // PUT /events/{id}
    @PutMapping("/{id}")
    public EventDetail updateEvent(@PathVariable String id, @RequestBody EventDetail event) {
        Optional<EventDetail> existing = eventService.getEventById(id);
        if (existing.isPresent()) {
            event.setEventId(id);
            return eventService.saveEventDetail(event);
        }
        return null;
    }

    // DELETE /events/{id}
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }
}
