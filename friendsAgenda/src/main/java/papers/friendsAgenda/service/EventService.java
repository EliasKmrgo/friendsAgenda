package papers.friendsAgenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import papers.friendsAgenda.domain.mongo.EventDetail;
import papers.friendsAgenda.repository.mongo.EventRepository;

@Service
public class EventService {
    final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public EventDetail saveEventDetail(EventDetail EventDetail) {
        return eventRepository.save(EventDetail);
    }

    public List<EventDetail> getAllEventDetails() {
        return eventRepository.findAll();
    }

    public Optional<EventDetail> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
