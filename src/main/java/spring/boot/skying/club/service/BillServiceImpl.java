package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.config.filter.JwtProvider.JwtTokenProperties;
import spring.boot.core.config.userdetail.UserPrincipal;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.dto.BillDTO;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.BillEntity;
import spring.boot.skying.club.entity.ProductEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.repository.BillRepository;
import spring.boot.skying.club.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl extends AbstractBaseService<BillEntity, BillDTO, BillRepository> implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected BillRepository getRepository() {
        return billRepository;
    }

    @Override
    protected void specificMapToDTO (BillEntity entity, BillDTO dto){
        super.specificMapToDTO(entity, dto);
        AccountEntity accountEntity = accountRepository.findById(entity.getAccountId()).orElse(null);
        dto.setUserName(accountEntity.getUsername());
        ProductEntity productEntity = productRepository.findById(entity.getProductId()).orElse(null);
        dto.setProductName(productEntity.getName());
    }


}
