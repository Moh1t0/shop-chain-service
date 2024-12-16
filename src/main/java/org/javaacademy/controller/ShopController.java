package org.javaacademy.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.javaacademy.dto.StatusDto;
import org.javaacademy.dto.UpdateGoodPriceDto;
import org.javaacademy.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
@Tag(name = "Shop Controller", description = "Контроллер для получения статуса магазинов и управления товарами")
public class ShopController {
    private final ShopService service;

    @Operation(
            tags = "Получение статуса магазинов",
            summary = "Получение статусов всех магазинов",
            description = "Возвращает статусы всех магазинов")
    @ApiResponse(
            responseCode = "200",
            description = "Успешно",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = StatusDto.class))))
    @GetMapping("/status")
    public List<StatusDto> getAllStatuses() {
        return service.getStatus();
    }

    @Operation(
            tags = "Обновление цены товара",
            summary = "Обновление цены товара",
            description = "Обновление цены товара в магазинах")
    @ApiResponse(
            responseCode = "200",
            description = "Цена товара успешно обновлена",
            content = @Content(mediaType = "application/json"))
    @PatchMapping("/good")
    public void updateGoodPrice(@RequestBody UpdateGoodPriceDto dto) {
        service.updateGoodPrice(dto);
    }
}
