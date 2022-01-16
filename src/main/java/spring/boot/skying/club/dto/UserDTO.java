package spring.boot.skying.club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.dto.BaseDTO;
import spring.boot.skying.club.entity.ParticipantEntity;

import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {

    private Long id;

    private Long userId;

    private String userName;

    private String avatar;

    private String email;

    private String phoneNumber;

    private Date dateOfBirth;

    private String interest;

    private Long score ;

    private Long coin;

    private List<String> achievement;

    private List<String> eventName;

}