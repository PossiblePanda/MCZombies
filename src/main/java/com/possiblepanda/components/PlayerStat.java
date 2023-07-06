package com.possiblepanda.components;

public class PlayerStat {
    private double zombie_kills;

    public void addZombieKill(int amount){
        zombie_kills += amount;
    }

    public double getZombie_kills() {
        return zombie_kills;
    }

    public void setZombie_kills(double zombie_kills) {
        this.zombie_kills = zombie_kills;
    }
}
