package se.jannatul.adventureGame.Model;

// Resident class, inheriting from Entity
public  class Resident extends Entity {

    // Constructor for Resident, initializing the role, health, and damage
     public Resident() {
         super("Resident", 12, 3);

     }

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }
}

