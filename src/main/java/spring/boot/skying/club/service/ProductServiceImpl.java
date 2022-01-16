package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.ProductDTO;
import spring.boot.skying.club.entity.ProductEntity;
import spring.boot.skying.club.repository.ProductRepository;

@Service
public class ProductServiceImpl extends AbstractBaseService<ProductEntity, ProductDTO, ProductRepository> implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    protected ProductRepository getRepository() {
        return productRepository;
    }

    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Override
    public Page<ProductDTO> search(ProductDTO dto, Pageable pageable) {
        return super.search(dto, pageable);
    }
}
