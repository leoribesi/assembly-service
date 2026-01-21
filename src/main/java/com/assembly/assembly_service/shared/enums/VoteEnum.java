package com.assembly.assembly_service.shared.enums;

import lombok.Getter;

@Getter
public enum VoteEnum {
    YES(1, "Sim"),
    NO(2, "Não");

    private final int key;
    private final String description;

    VoteEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
