import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // your code here
        boolean isValidInput = false;
        while (!isValidInput) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter what shape you want to calculate the area of: ");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            int shape = input.nextInt();

            switch (shape) {
                case 1:
                    isValidInput = true;
                    System.out.println("Calculating Area of Rectangle: ");
                    System.out.println("Enter width: ");
                    float w = input.nextFloat();
                    System.out.println("Enter height: ");
                    float h = input.nextFloat();
                    Rectangle rectangle = new Rectangle(w, h);
                    System.out.println("Area " + rectangle.calculateArea());
                    break;
                case 2:
                    isValidInput = true;
                    System.out.println("Calculating Area of Circle: ");
                    System.out.println("Enter radius: ");
                    float r = input.nextFloat();
                    Circle circle = new Circle(r);
                    circle.draw();
                    System.out.println("Area: " + circle.calculateArea());
                    break;
                default:
                    System.out.println("Please enter a valid number");
                    break;
            }
        }
    }
}
