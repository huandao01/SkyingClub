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
            " where (:#{#dto.username} is null or lower(e.username) like :#{#dto.username}) " +
            " and (:#{#dto.fullName} is null or lower(e.fullName) like :#{#dto.fullName}) " +
            " and (e.role = :#{#dto.role} or :#{#dto.role} is null) "
    )
    Page<AccountEntity> search(AccountDTO dto, Pageable pageable);

    @Query("select case when count(e) > 0 then true else false end from AccountEntity e"
            + " where e.username = :#{#username}"
            + " and (e.id <> :#{#id} or :#{#id} is null)")
    boolean existsByUsernameNotPassword(String username, Long id);

    boolean existsByUsername(String username);

    AccountEntity findByUsername(String username);
}
