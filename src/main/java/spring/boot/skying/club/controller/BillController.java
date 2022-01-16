package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.BillDTO;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.service.BillService;
import spring.boot.skying.club.service.PostService;

@RequestMapping("/bill")
@RestController
@CrossOrigin
public class BillController extends BaseController<BillDTO, BillService> {
    @Autowired
    private BillService billService;

    @Override
    public BillService getService() {
        return billService;
    }
}
