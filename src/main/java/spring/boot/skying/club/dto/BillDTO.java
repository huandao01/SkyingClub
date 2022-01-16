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
public class BillDTO extends BaseDTO {
    private Long id;

    private Long accountId;

    private String userName;

    private Long productId;

    private String productName;

    private Long numberProduct;

    private Long totalCost;

}
