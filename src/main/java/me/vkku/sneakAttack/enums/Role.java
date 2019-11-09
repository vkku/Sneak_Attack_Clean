package me.vkku.sneakAttack.enums;

public enum Role {

    KILLER("killer"),
    INNOCENT("innocent"),
    HEALER("healer"),
    SHERLOCK("sherlock");

    public String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
