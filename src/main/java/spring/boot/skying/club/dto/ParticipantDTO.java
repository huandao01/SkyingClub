package spring.boot.skying.club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO extends BaseDTO {
    private Long id;

    private String nameEvent;

    private String eventId;

    private String nameUser;

    private String userId;

    private String avatar;

    private Long achievement;

}
