package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.LikeDTO;
import spring.boot.skying.club.service.LikeService;

@RestController
@RequestMapping("/like")
@CrossOrigin
public class LikeController extends BaseController<LikeDTO, LikeService> {
    @Autowired
    private LikeService likeService;
    @Override
    public LikeService getService() {
        return likeService;
    }
}
