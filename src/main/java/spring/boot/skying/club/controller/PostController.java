package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.service.PostService;

@RequestMapping("/post")
@RestController
@CrossOrigin
public class PostController extends BaseController<PostDTO, PostService> {
    @Autowired
    private PostService postService;

    @Override
    public PostService getService() {
        return postService;
    }
}
