package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.ProductDTO;
import spring.boot.skying.club.service.ProductService;

@RequestMapping("/product")
@RestController
@CrossOrigin
public class ProductController extends BaseController<ProductDTO, ProductService> {
    @Autowired
    private ProductService productService;

    @Override
    public ProductService getService() {
        return productService;
    }
}
