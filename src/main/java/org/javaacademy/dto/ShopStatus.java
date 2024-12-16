package org.javaacademy.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Статус магазина")
public enum ShopStatus {
    WORK, CLOSED;
}
