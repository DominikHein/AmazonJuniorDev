public class Dolphin extends Animal implements Swim{

    String color;
    int swimmingSpeed;

    public Dolphin(){
        super("Dolphin");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Dolphin: I have eaten fish.");
    }

    public void eatingFood(){
        System.out.println("Dolphin: I am eating delicious fish.");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public void swimming(){
        System.out.println("Dolphin: I am swimming at the speed " + swimmingSpeed);
    }
}
