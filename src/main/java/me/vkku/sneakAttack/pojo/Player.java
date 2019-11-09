package me.vkku.sneakAttack.pojo;

import me.vkku.sneakAttack.enums.Role;
import me.vkku.sneakAttack.enums.State;

public class Player {

    Role role;
    State state;
    int suspects;

    public Player(Role role){
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getSuspects() {
        return suspects;
    }

    public void setSuspects(int suspects) {
        this.suspects = suspects;
    }
}
