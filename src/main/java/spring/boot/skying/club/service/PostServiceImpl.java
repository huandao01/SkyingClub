package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.entity.PostEntity;
import spring.boot.skying.club.repository.PostRepository;

@Service
public class PostServiceImpl extends AbstractBaseService<PostEntity, PostDTO, PostRepository> implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    protected PostRepository getRepository() {
        return postRepository;
    }
}
