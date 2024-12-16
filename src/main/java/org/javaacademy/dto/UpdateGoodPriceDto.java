package org.javaacademy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Обновление цены товара")
public class UpdateGoodPriceDto {

    @Schema(description = "Название товра")
    private String name;

    @JsonProperty("new_price")
    @Schema(description = "Новая цена")
    private BigDecimal newPrice;
}
