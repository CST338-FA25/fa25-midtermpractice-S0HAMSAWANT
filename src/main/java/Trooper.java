import java.util.*;
public abstract class Trooper {
    private final String unit;
    private final int number;

    private final String trooperKind;
    private final double marchSpeed;
    private final double marchModifier;

    public Trooper(){
        this("AA", 0);
    }
    public Trooper(String unit, int number){
        this.unit = unit;
        this.number = number;
        this.marchSpeed = 5.0;
        this.marchModifier = 1.0;
        this.trooperKind = "";
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t){
        if(units == null || t == null)return;
        String key = t.getUnit();
        units.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
    }

    public abstract double march(double duration);

    public boolean attack(Trooper target,int roll){
        System.out.println(this + " is attacking" + target);
        System.out.println(this + " rolled a " + roll);

        if(this == target || roll == 1){
            System.out.println(this + "is targeting itself...");
            System.out.println(this + " rolled a " + roll + " and hurt itself in the confusion.");
            return true;
        }

        if(this instanceof StormTrooper){
            if(target instanceof RebelTrooper) {
                System.out.println("Rolled a " + roll + " againist the rebel scum");
                return (roll > 10) && (roll % 2 == 0);
            } else if (target instanceof StormTrooper) {
                System.out.println("No Treason in the ranks!");
                return false;
            }else{
                System.out.println("Acceptable Collateral Damage!");
                return (roll > 10) || (roll % 2 ==0);
            }else{
                System.out.println("Acceptable Collateral Damage!");
                return (roll > 10) || (roll % 2 == 0);
            }
        }else if(this instanceof RebelTrooper){
            if(target instanceof RebelTrooper){
                System.out.println("Imperial Spy!");
                return false;
            }else if(target instanceof StormTrooper){
                System.out.println("Rolled a " + roll + " against the imperial scum");
                return (roll > 5) || (roll % 2 != 0);
            }
        }

        return roll % 2 == 0;


    public String getUnit() {
        return unit;
    }

    public int getNumber() {
        return number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public double getMarchModifier() {
        return marchModifier;
    }
}

    @Override
    public String toString() {
        return "Trooper{" +
                "unit='" + unit + '\'' +
                ", number=" + number +
                ", trooperKind='" + trooperKind + '\'' +
                ", marchSpeed=" + marchSpeed +
                ", marchModifier=" + marchModifier +
                '}';
    }
