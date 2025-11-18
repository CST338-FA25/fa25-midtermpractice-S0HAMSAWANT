import java.util.*;

public abstract class Trooper {
    private String unit;
    private int number;

    private String trooperKind;
    private double marchSpeed;
    private double marchModifier;

    public Trooper() {
        this("AA", 0);
    }


    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        this.marchSpeed = 5.0;
        this.marchModifier = 1.0;
        this.trooperKind = "";
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        if (units == null || t == null) return;
        String key = t.getUnit();
        units.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
    }
    public abstract double march(double duration);

    public boolean attack(Trooper target, int roll) {
        System.out.println(this + " is attacking " + target);
        System.out.println(this + " rolled a " + roll);

        if (this == target || roll == 1) {
            System.out.println(this + " is targeting itself...");
            System.out.println(this + " rolled a " + roll + " and hurt itself in the confusion.");
            return true;
        }

        if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Rolled a " + roll + " against the rebel scum");
                return (roll > 10) && (roll % 2 == 0);
            } else if (target instanceof StormTrooper) {
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable Collateral Damage!");
                return (roll > 10) || (roll % 2 == 0);
            }
        } else if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target instanceof StormTrooper) {
                System.out.println("Rolled a " + roll + " against the imperial scum");
                return (roll > 5) || (roll % 2 != 0);
            } else {
                System.out.println("Rebels target an innocent bystander");
                return (roll >= 18) && (roll % 2 == 0);
            }
        }
        return roll % 2 == 0;
    }
    @Override
    public String toString() {
        return unit + number + ": ";
    }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getTrooperKind() { return trooperKind; }
    public void setTrooperKind(String trooperKind) { this.trooperKind = trooperKind; }

    public double getMarchSpeed() { return marchSpeed; }
    public void setMarchSpeed(double marchSpeed) { this.marchSpeed = marchSpeed; }

    public double getMarchModifier() { return marchModifier; }
    public void setMarchModifier(double marchModifier) { this.marchModifier = marchModifier; }
}
