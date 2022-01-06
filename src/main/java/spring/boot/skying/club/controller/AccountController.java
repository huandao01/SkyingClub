package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.controller.BaseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController extends BaseController<AccountDTO, AccountService> {

    @Autowired
    private AccountService service;


    @Override
    public AccountService getService() {
        return service;
    }

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody AccountDTO accountDTO) {
        return response(getService().register(accountDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody UsernameAndPasswordDTO usernameAndPasswordDTO) {
        return response(getService().login(usernameAndPasswordDTO));
    }

    @GetMapping("/get-user")
    public ResponseDTO getUser(UserDTO dto,
                               @PageableDefault(size = 200, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return response(getService().getUser(dto, pageable));
    }
}
