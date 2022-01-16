package spring.boot.skying.club.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.dao.repository.BaseRepository;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.dto.ProductDTO;
import spring.boot.skying.club.entity.PostEntity;
import spring.boot.skying.club.entity.ProductEntity;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, ProductDTO,Long> {
    @Override
    @Query("select e from ProductEntity e" +
            "  ")
    Page<ProductEntity> search(ProductDTO dto, Pageable pageable);
}
