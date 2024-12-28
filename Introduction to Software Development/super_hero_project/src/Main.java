//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int calculatePunchDamage(int strength){

        return strength * 2;
    }

    public static int calculateSpecialAttackDamage(int strength, String attackType){
        if (attackType.equals("Fire Punch")){
            return strength * 3;
        }else if(attackType.equals("Ice Blast")){
            return  strength * 2;
        }else
            return strength;
    }

    public static void main(String[] args) {

        int villainHealth = 100;
        int punchStrength = 20;
        String attackType = "Fire Punch";

        int damageByPunch = calculatePunchDamage(punchStrength);

        int damageBySpecialAttack  = calculateSpecialAttackDamage(punchStrength, attackType);

        int remainingHealth = villainHealth - (damageByPunch + damageBySpecialAttack);

        System.out.println("Villain's remaining health: " + remainingHealth);
    }
}