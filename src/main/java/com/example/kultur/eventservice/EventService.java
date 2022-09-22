package com.example.kultur.eventservice;

import com.example.kultur.model.Event;
import com.example.kultur.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Event save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(eventRepository.findAll());
    }

}