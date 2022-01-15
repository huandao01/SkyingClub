package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.ParticipantDTO;
import spring.boot.skying.club.service.ParticipantService;

@RequestMapping("/participant")
@RestController
@CrossOrigin
public class ParticipantController extends BaseController<ParticipantDTO, ParticipantService> {
    @Autowired
    private ParticipantService participantService;

    @Override
    public ParticipantService getService() {
        return participantService;
    }
}
