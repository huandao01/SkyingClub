package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.UserDTO;

import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.EventEntity;
import spring.boot.skying.club.entity.ParticipantEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.entity.UserEntity;

import spring.boot.skying.club.repository.ParticipantRepository;
import spring.boot.skying.club.repository.UserRepository;


@Service
public class UserServiceImpl extends AbstractBaseService<UserEntity, UserDTO, UserRepository> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantServiceImpl service;

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    @Override
    protected void specificMapToDTO(UserEntity entity, UserDTO dto) {
        super.specificMapToDTO(entity, dto);
        AccountEntity accountEntity = accountRepository.findById(entity.getUserId()).orElse(null);
        if(accountEntity != null) {
            dto.setUserName(accountEntity.getFullName());
            dto.setAvatar(accountEntity.getAvatar());
            dto.setEmail(accountEntity.getEmail());
            dto.setAchievement(userRepository.findAchievement(entity.getUserId()));
            dto.setEventName(userRepository.findEventName(entity.getUserId()));
        }
    }



}