package se.jannatul.adventureGame.Model;

// Abstract class
abstract  class Entity {
    private  String role; // Role of the entity (Resident or Burglar)
    private int  health; // Health of the entity
    private int damage; // Damage a entity can make

    // initialize constructor
    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;

    }
    // Getter for health, returns health
    public int getHealth() {
        return health;
    }
    // Getter for damage, returns damage
    public int getDamage() {
        return damage;
    }
    // Getter for role, returns role of the entity
    public String getRole() {
        return role;

    }
    // Method for one entity to attack another
    public void punch(Entity toPunch){
        toPunch.takeHit(this.damage);
    }
    // Method to increase the damage of entity
    public void addDamage(int damage){
        this.damage += damage; // Add extra damage to the current damage

    }
    // Method to check if the entity is still conscious (health > 0)
    public boolean isConcious() {
        return this.health > 0;
    }
    // Method to apply damage to the entity, reducing its health
    public void takeHit(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;  // health doesn’t go below zero
        }
    }
}
