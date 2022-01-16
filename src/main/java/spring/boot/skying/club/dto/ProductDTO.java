package spring.boot.skying.club.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.hpsf.Decimal;
import spring.boot.core.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseDTO {
    private Long id;

    private String name;

    private String content;

    private String imgPath;

    private Long numberProductAvailable;

    private Long price;

}
