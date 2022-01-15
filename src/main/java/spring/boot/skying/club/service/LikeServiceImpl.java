package spring.boot.skying.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.exception.BaseException;
import spring.boot.core.service.AbstractBaseService;
import spring.boot.skying.club.dto.LikeDTO;
import spring.boot.skying.club.entity.LikeEntity;
import spring.boot.skying.club.repository.LikeRepository;

@Service
public class LikeServiceImpl extends AbstractBaseService<LikeEntity, LikeDTO, LikeRepository> implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    protected LikeRepository getRepository() {
        return likeRepository;
    }

    @Override
    protected void beforeSave(LikeEntity entity, LikeDTO dto) {
        if(getRepository().existsByUserIdAndPostId(dto.getUserId(),dto.getPostId())){
            throw new BaseException("Đã like");
        }
        super.beforeSave(entity, dto);
    }

}
