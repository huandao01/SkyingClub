package spring.boot.skying.club.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.CommentDTO;
import spring.boot.skying.club.entity.CommentEntity;

@Repository
public interface CommentRepository extends BaseRepository<CommentEntity, CommentDTO,Long> {
    Long countByUserId(Long id);
}
