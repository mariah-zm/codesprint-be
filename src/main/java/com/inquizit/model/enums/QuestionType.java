package com.inquizit.model.enums;

public enum QuestionType {
    SINGLE_ANSWER(1),
    MULTIPLE_ANSWERS(2),
    TRUE_FALSE(3);

    private final int value;

    QuestionType(int value) {
        this.value = value;
    }

    public int getValue() {
        for (QuestionType type : values()) {
            if (type.value == value) {
                return value;
            }
        }
        return 0;
    }
}
