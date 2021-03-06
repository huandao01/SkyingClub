package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.entity.AccountEntity;

import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<AccountEntity, AccountDTO, Long> {

    @Override
    @Query("select e from AccountEntity e" +
            " where (lower(e.username) like %:#{#dto.username}% or :#{#dto.username} is null) " +
            " and (lower(e.fullName) like %:#{#dto.fullName}% or :#{#dto.fullName} is null) " +
            " and (e.role = :#{#dto.role} or :#{#dto.role} is null) "
    )
    Page<AccountEntity> search(AccountDTO dto, Pageable pageable);


    boolean existsByUsername(String username);

    boolean existsByEmail(String username);

    AccountEntity findByUsername(String username);
}
