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
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.dto.UserDTO;
import spring.boot.skying.club.repository.UserRepository;
import spring.boot.skying.club.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController<UserDTO, UserService> {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Override
    public UserService getService() {
        return service;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseDTO getDetail(@PathVariable Long id) {
        return response(getService().findDetailById(repository.search(id)));
    }


}