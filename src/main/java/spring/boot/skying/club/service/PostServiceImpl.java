package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.PostEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.repository.PostRepository;

@Service
public class PostServiceImpl extends AbstractBaseService<PostEntity, PostDTO, PostRepository> implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected PostRepository getRepository() {
        return postRepository;
    }

    @Override
    protected void specificMapToDTO(PostEntity entity, PostDTO dto) {
        AccountEntity accountEntity = accountRepository.findById(entity.getCreatedBy()).orElse(null);
        if(accountEntity != null){
            dto.setAuthor(accountEntity.getFullName());

        }
    }
}
