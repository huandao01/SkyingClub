package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.EventDTO;
import spring.boot.skying.club.entity.EventEntity;

@Repository
public interface EventRepository extends BaseRepository<EventEntity, EventDTO,Long> {
    @Override
    @Query("select e from EventEntity e" +
            " where (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null) ")
    Page<EventEntity> search(EventDTO dto, Pageable pageable);
}
