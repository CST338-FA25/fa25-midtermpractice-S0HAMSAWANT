public class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soldierCount = 0;

    // (unit, number, name)
    public RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        soldierCount++;
        setTrooperKind("pilot");
        setMarchModifier(0.75);
        this.name = name;
    }

    @Override
    public double march(double duration) {
        return getMarchSpeed() * duration * getMarchModifier();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static int getSoldierCount() { return soldierCount; }

    @Override
    public String toString() {
        return name + "(" + super.toString() + ") a " + getTrooperKind();
    }
}
