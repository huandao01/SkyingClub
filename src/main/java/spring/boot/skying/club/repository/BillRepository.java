package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.BillDTO;
import spring.boot.skying.club.dto.ProductDTO;
import spring.boot.skying.club.entity.BillEntity;
import spring.boot.skying.club.entity.ProductEntity;

@Repository
public interface BillRepository extends BaseRepository<BillEntity, BillDTO,Long> {
    @Override
    @Query("select e from BillEntity e" +
            " where (e.accountId = :#{#dto.accountId}) or :#{#dto.accountId} is null" +
            " and (e.productId = :#{#dto.productId}) or :#{#dto.productId} is null"
    )
    Page<BillEntity> search(BillDTO dto, Pageable pageable);
}
