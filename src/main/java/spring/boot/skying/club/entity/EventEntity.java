package spring.boot.skying.club.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "event")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class EventEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEvent;

    private Date timeout;// thời gian kết thúc đăng kí 16/1/2022

    private String imgPath;

    @Column(length = 2000)
    private String content;
}
