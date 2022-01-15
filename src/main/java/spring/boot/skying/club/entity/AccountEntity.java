package spring.boot.skying.club.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.dao.model.BaseEntity;

import javax.persistence.*;
/*
*  tương đương với 1 bảng tỏng database
*  sd kỹ thuật orm
*  1 bảng ghi tỏng database sẽ map thành một object này
* */
@Entity
@Table(name = "account")
@Where(clause = "deleted=0") // 
@Getter
@Setter
@NoArgsConstructor // tạo phương thức khởi tạo k có arg
public class AccountEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String avatar;

    public Long getRole() {
        return role;
    }

    /**
     * 1: admin
     * 2: user
     * 3: guest
     */
    private Long role;
}
