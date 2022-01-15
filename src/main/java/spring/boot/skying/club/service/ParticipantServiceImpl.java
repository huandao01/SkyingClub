package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.ParticipantDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.EventEntity;
import spring.boot.skying.club.entity.ParticipantEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.repository.EventRepository;
import spring.boot.skying.club.repository.ParticipantRepository;

@Service
public class ParticipantServiceImpl extends AbstractBaseService<ParticipantEntity, ParticipantDTO, ParticipantRepository> implements ParticipantService {
    @Autowired
    private ParticipantRepository ParticipantRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    protected ParticipantRepository getRepository() {
        return ParticipantRepository;
    }

    @Override
    protected void specificMapToDTO(ParticipantEntity entity, ParticipantDTO dto) {
        super.specificMapToDTO(entity, dto);
        AccountEntity accountEntity = accountRepository.findById(entity.getUserId()).orElse(null);
        dto.setNameUser(accountEntity.getFullName());
        dto.setAvatar(accountEntity.getAvatar());
        EventEntity eventEntity = eventRepository.findById(entity.getEventId()).orElse(null);
        dto.setNameEvent(eventEntity.getNameEvent());
    }
}
