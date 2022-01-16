package spring.boot.skying.club.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String phoneNumber;

    private Date dateOfBirth;

    @Column(length = 2000)
    private String interest;

    private Long coin ;

    private Long score ;
}
