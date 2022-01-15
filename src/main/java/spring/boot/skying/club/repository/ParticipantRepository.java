package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.ParticipantDTO;
import spring.boot.skying.club.entity.ParticipantEntity;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends BaseRepository<ParticipantEntity, ParticipantDTO,Long> {

    @Override
    @Query("select e from ParticipantEntity e" +
            " where (e.eventId = :#{#dto.eventId} or :#{#dto.eventId} is null)" +
            " and (e.userId = :#{#dto.userId} or :#{#dto.userId} is null) ")
    Page<ParticipantEntity> search(ParticipantDTO dto, Pageable pageable);

}
