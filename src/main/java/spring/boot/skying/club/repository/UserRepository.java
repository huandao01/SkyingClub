package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.entity.UserEntity;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, UserDTO,Long> {

    @Override
    @Query("select e from UserEntity e" +
            " where e.userId = :#{#dto.userId} or :#{#dto.userId} is null" +
            " order by e.score desc")
    Page<UserEntity> search(UserDTO dto, Pageable pageable);

    @Query(value = "select  p.achievement from participant p, event e, account a where p.user_id = a.id and p.event_id = e.id and a.id = :id",nativeQuery= true)
    public List<String> findAchievement(@Param("id") Long id);

    @Query(value = "select  e.name_event from participant p, event e, account a where p.user_id = a.id and p.event_id = e.id and a.id = :id",nativeQuery= true)
    public List<String> findEventName(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO userinfo ( user_id,create_at,deleted,update_at,score,coin) VALUES (:id, :date,0,:date,0,0);",nativeQuery=true)
    public void addRecord(@Param("id") Long id, @Param("date") Date date);

    @Query(value = "select currval('account_id_seq');",nativeQuery= true)
    public Long  getAccountSpecialId();

    @Query(value = "select e.id from userinfo  e where e.user_id = :id",nativeQuery= true)
    public Long  search(@Param("id") Long id);





}
