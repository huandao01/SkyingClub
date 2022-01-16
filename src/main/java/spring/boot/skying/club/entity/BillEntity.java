package spring.boot.skying.club.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "bill")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class BillEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private Long productId;

    private Long numberProduct;

    private Long totalCost;
}
