package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.config.filter.JwtProvider;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.core.utils.DigestUtil;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.core.config.filter.JwtProvider.JwtTokenProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl extends AbstractBaseService<AccountEntity, AccountDTO, AccountRepository> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected AccountRepository getRepository() {
        return accountRepository;
    }

    @Override
    protected void beforeSave(AccountEntity entity, AccountDTO dto) {
        if(entity.getId() != null){
            AccountEntity accountEntity = getRepository().findById(entity.getId()).orElse(new AccountEntity());
            entity.setUsername(accountEntity.getUsername());
            entity.setPassword(accountEntity.getPassword());
        }
        super.beforeSave(entity, dto);
    }

    @Override
    public Map<String, Object> login(UsernameAndPasswordDTO dto) {
        if (dto.getPassword() == null || dto.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập tên đăng nhập hoặc mật khẩu");
        }
        AccountEntity userEntity = getRepository().findByUsername(dto.getUsername());
        if (userEntity == null) {
            throw new BaseException(400, "Tên đăng nhập không tồn tại");
        }

        if (!DigestUtil.sha256Hex(dto.getPassword()).equals(userEntity.getPassword())) {
            throw new BaseException(400, "password không chính xác");
        }

        List<String> roles = new ArrayList<>();

        if (userEntity.getRole() != null) {
            roles.add("ROLE_" + userEntity.getRole());
        }

        JwtTokenProperties jwts = JwtTokenProperties.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .fullName(userEntity.getFullName())
                .role(roles.get(0))
                .avatar(userEntity.getAvatar())
                .privileges(roles)
                .build();

        return jwtProvider.generateToken(jwts);
    }

    @Override
    public AccountDTO register(AccountDTO accountDTO) {
        if (accountDTO.getPassword() == null || accountDTO.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập username và password");
        }
        if(getRepository().existsByUsername(accountDTO.getUsername())){
            throw new BaseException("Tên đăng nhập đã tồn tại");
        }
        AccountEntity accountEntity = mapToEntity(accountDTO);

        accountEntity.setRole(3L);
        accountEntity.setPassword(DigestUtil.sha256Hex(accountDTO.getPassword()));
        save(accountEntity,accountDTO);

        return accountDTO;
    }
}
