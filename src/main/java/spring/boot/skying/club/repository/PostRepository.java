package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.entity.PostEntity;

@Repository
public interface PostRepository extends BaseRepository<PostEntity, PostDTO,Long> {
    @Override
    @Query("select e from PostEntity e" +
            " where (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null) ")
    Page<PostEntity> search(PostDTO dto, Pageable pageable);
}
