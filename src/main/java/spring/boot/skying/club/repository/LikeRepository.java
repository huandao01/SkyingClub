package spring.boot.skying.club.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.LikeDTO;
import spring.boot.skying.club.entity.LikeEntity;

@Repository
public interface LikeRepository extends BaseRepository<LikeEntity, LikeDTO, Long> {
    Long countByUserId(Long id);

    Long countByPostId(Long id);

    Boolean existsByUserIdAndPostId(Long userId, Long postId);
}
