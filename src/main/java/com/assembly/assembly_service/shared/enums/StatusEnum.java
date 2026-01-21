package com.assembly.assembly_service.shared.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    OPENED(1, "Aberto"),
    CLOSED(2, "Fechado");

    private final int key;
    private final String description;

    StatusEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
