package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.repository.AccountRepository;

import java.util.Map;

public interface AccountService extends BaseService<AccountDTO> {
    Map<String,Object> login(UsernameAndPasswordDTO dto);

    AccountDTO register(AccountDTO account);

    AccountDTO getCurrentUser();

    Long getCurrentUserId();

    Page<UserDTO> getUser(UserDTO userDTO, Pageable page);
}
