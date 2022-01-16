package spring.boot.skying.club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO extends BaseDTO {
    private Long id;

    private String nameEvent;

    private Date timeout; // ngày kết thúc

    private String imgPath;

    private String content;

    private Boolean isRegister = true;
}
