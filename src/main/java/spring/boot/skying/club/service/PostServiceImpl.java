package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.AccountDTO;
import spring.boot.skying.club.dto.PostDTO;
import spring.boot.skying.club.entity.AccountEntity;
import spring.boot.skying.club.entity.PostEntity;
import spring.boot.skying.club.repository.AccountRepository;
import spring.boot.skying.club.repository.CommentRepository;
import spring.boot.skying.club.repository.LikeRepository;
import spring.boot.skying.club.repository.PostRepository;

@Service
public class PostServiceImpl extends AbstractBaseService<PostEntity, PostDTO, PostRepository> implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    protected PostRepository getRepository() {
        return postRepository;
    }

    @Override
    protected void specificMapToDTO(PostEntity entity, PostDTO dto) {
        AccountEntity accountEntity = accountRepository.findById(entity.getCreatedBy()).orElse(null);
        if (accountEntity != null) {
            dto.setAuthor(accountEntity.getFullName());
            dto.setAvatar(accountEntity.getAvatar());
        }

        dto.setNumberLike(likeRepository.countByPostId(entity.getId()));
        dto.setNumberComment(commentRepository.countByPostId(entity.getId()));

        Long currentUserId = accountService.getCurrentUserId();
        dto.setIsLike(likeRepository.existsByUserIdAndPostId(currentUserId, entity.getId()));

    }
}
