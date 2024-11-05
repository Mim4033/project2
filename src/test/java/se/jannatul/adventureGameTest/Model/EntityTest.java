package se.jannatul.adventureGameTest.Model;
public abstract class EntityTest{
    private String name;
    private int health;
    private int damage;

    public EntityTest(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void punch(EntityTest toPunch) {
        toPunch.takeHit(this.damage);
    }

    public void takeHit(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0; // Ensure health doesn’t go below zero
        }
    }

    public boolean isConscious() {
        return this.health > 0;
    }
}
