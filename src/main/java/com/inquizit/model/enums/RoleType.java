package com.inquizit.model.enums;


public enum RoleType {
    STUDENT(1),
    TEACHER(2);

    private final int value;

    RoleType(int value) {
        this.value = value;
    }

    public static RoleType getRoleType(int value) {
        for (RoleType type : values()) {
            if (type.value == value) {
                return type;
            }
        }

        return null;
    }

    public int getValue() {
        for (RoleType type : values()) {
            if (type.value == value) {
                return value;
            }
        }
        return 0;
    }
}
