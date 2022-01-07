package spring.boot.skying.club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO extends BaseDTO {
    private Long id;

    private Long userId;

    private Long postId;

    private String fullName;

    private String avatar;

    private String content;
}
