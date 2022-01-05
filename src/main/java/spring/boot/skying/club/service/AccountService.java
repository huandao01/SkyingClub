package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.repository.AccountRepository;

import java.util.Map;

public interface AccountService extends BaseService<AccountDTO> {
    Map<String,Object> login(UsernameAndPasswordDTO dto);

    AccountDTO register(AccountDTO account);
}
