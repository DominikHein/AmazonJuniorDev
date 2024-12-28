public class Penguin extends Animal implements Walk, Swim{

    private boolean isSwimming;
    private int walkSpeed;
    private int swimSpeed;

    public Penguin(){
        super("Penguin");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Penguin: I have eaten fish.");
    }

    public void eatingFood(){
        System.out.println("Penguin: I am eating delicious fish.");
    }

    @Override
    public void swimming() {
        if (isSwimming){
            System.out.println("Penguin: I am swimming at the speed of " + (int)swimSpeed);
        }else {
            System.out.println("Penguin: I am swimming at the speed " + swimSpeed + " nautical miles per hour" );
        }
    }

    @Override
    public void walking() {
        if (!isSwimming){
            System.out.println("Penguin: I am walking at the speed " + (int) walkSpeed + " mph");
        }else {
            System.out.println("Penguin: I cannot walk while swimming");
        }
    }

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

}
