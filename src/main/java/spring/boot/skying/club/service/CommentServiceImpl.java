package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.CommentDTO;
import spring.boot.skying.club.entity.CommentEntity;
import spring.boot.skying.club.repository.CommentRepository;

@Service
public class CommentServiceImpl extends AbstractBaseService<CommentEntity, CommentDTO, CommentRepository> implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    protected CommentRepository getRepository() {
        return commentRepository;
    }
}
