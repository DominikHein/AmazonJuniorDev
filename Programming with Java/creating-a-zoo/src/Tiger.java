public class Tiger extends Animal implements Walk{
    private int numberOfStripes;
    private int speed;
    private int soundLevelOfRoar;

    public Tiger(){
        super("Tiger");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Tiger: I have eaten meat.");
    }

    public void eatingFood(){
        System.out.println("The animal: " + getNameOfAnimal() + " is eating.");
    }

    public int getSpeed() {
        return speed;
    }

    public int getSoundLevel() {
        return soundLevelOfRoar;
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSoundLevel(int soundLevelOfRoar) {
        this.soundLevelOfRoar = soundLevelOfRoar;
    }

    @Override
    public void walking() {
        System.out.println("Tiger: I am moving at the speed " + speed);
    }
}
