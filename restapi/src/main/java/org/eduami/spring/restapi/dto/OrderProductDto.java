package org.eduami.spring.restapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private List<ProductDto> products;
    private Integer totalValue;
}
