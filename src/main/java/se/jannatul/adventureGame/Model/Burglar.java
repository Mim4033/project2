package se.jannatul.adventureGame.Model;

// Burglar class, inheriting from Entity
public class Burglar extends Entity {

    // Constructor for Burglar, initializing the role, health, and damage
    public Burglar() {
        super("Burglar", 12, 4);
    }

    public Burglar(String role, int health, int damage) {
        super(role, health, damage);
    }
}

