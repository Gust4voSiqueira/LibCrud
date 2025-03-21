package br.com.libcrud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Active {

    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    private final String description;
}
