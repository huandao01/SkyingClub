package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.CommentDTO;
import spring.boot.skying.club.entity.CommentEntity;

@Repository
public interface CommentRepository extends BaseRepository<CommentEntity, CommentDTO,Long> {
    Long countByUserId(Long id);

    Long countByPostId(Long id);

    @Override
    @Query("select e from CommentEntity e" +
            " where (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null)" +
            " and (e.postId = :#{#dto.postId} or :#{#dto.postId} is null)" +
            " and (e.userId = :#{#dto.userId} or :#{#dto.userId} is null) ")
    Page<CommentEntity> search(CommentDTO dto, Pageable pageable);
}
