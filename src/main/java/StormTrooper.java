
public class StormTrooper extends Trooper {
    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String unit, int number) {
        super(unit, number);
        soldierCount++;
        setTrooperKind("StormTrooper");
        setMarchModifier(1.10);
    }

    public double march(double duration) {
        return getMarchSpeed() * duration * getMarchModifier();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public String toString() {
        String label = (name == null) ? "" : name;
        if (label.isEmpty()) {
            return "(" + super.toString() + ") a " + getTrooperKind();
        } else {
            return label + "(" + super.toString() + ") a " + getTrooperKind();
        }
    }
}
