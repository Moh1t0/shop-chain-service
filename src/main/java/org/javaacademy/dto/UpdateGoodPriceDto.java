package org.javaacademy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodPriceDto {
    private String name;
    @JsonProperty("new_price")
    private BigDecimal newPrice;
}
