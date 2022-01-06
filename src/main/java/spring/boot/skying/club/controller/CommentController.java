package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.controller.BaseController;
import spring.boot.skying.club.dto.CommentDTO;
import spring.boot.skying.club.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController extends BaseController<CommentDTO, CommentService> {
    @Autowired
    private CommentService commentService;
    @Override
    public CommentService getService() {
        return commentService;
    }
}
