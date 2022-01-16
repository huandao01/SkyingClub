package spring.boot.skying.club.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.service.BaseService;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.dto.BillDTO;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.repository.BillRepository;

import java.util.Map;

public interface BillService extends BaseService<BillDTO> {

}
