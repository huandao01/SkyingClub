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
public class PostDTO extends BaseDTO {
    private Long id;

    private String content;

    private String imgPath;

    private String author;

    private Long numberLike;

    private Long numberComment;

    private Boolean isLike;

    private String avatar;
}
