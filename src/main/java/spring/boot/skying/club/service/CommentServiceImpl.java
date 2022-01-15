package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.CommentDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.CommentEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.repository.CommentRepository;

@Service
public class CommentServiceImpl extends AbstractBaseService<CommentEntity, CommentDTO, CommentRepository> implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected CommentRepository getRepository() {
        return commentRepository;
    }

    @Override
    protected void specificMapToDTO(CommentEntity entity, CommentDTO dto) {
        super.specificMapToDTO(entity, dto);
        AccountEntity accountEntity = accountRepository.findById(entity.getCreatedBy()).orElse(null);
        dto.setFullName(accountEntity.getFullName());
        dto.setAvatar(accountEntity.getAvatar());
    }
}
