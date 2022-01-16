package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;

import spring.boot.skying.club.dto.EventDTO;

import spring.boot.skying.club.entity.EventEntity;

import spring.boot.skying.club.repository.EventRepository;


@Service
public class EventServiceImpl extends AbstractBaseService<EventEntity, EventDTO, EventRepository> implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    protected EventRepository getRepository() {
        return eventRepository;
    }



}