package spring.boot.skying.club.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;


import javax.persistence.*;

@Entity
@Table(name = "participant")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class ParticipantEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Long userId;

    private int achievement;
}
