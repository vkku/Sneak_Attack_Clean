package me.vkku.sneakAttack.enums;

public enum State {

    ALIVE("alive"),
    DEAD("dead");

    public String state;

    State(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
