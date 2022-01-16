package spring.boot.skying.club.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.boot.core.service.BaseService;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.dto.ProductDTO;
import spring.boot.skying.club.repository.ProductRepository;

public interface ProductService extends BaseService<ProductDTO> {
    ProductRepository getProductRepository();

    @Override
    Page<ProductDTO> search(ProductDTO dto, Pageable pageable);
}
