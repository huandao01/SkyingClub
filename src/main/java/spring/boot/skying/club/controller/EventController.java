package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.EventDTO;
import spring.boot.skying.club.service.EventService;

@RequestMapping("/event")
@RestController
@CrossOrigin
public class EventController extends BaseController<EventDTO,EventService> {
    @Autowired
    private EventService eventService;
    @Override
    public EventService getService() {
        return eventService;
    }
}