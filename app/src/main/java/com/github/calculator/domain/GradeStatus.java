package com.github.calculator.domain;

public enum GradeStatus {
    APROVADO("APROVADO"),
    APROVADO_POR_NOTA("APROVADO POR NOTA"),
    REPROVADO("REPROVADO"),
    NAO_VALIDADO("NAO VALIDADO");

    private final String value;

    GradeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
