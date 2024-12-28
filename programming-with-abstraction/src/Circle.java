import java.awt.*;

public class Circle extends shape{
    private float radius;

    Circle(float r){
        this.radius = r;
    }

    @Override
    public float calculateArea() {
        return (float)Math.PI * this.radius * this.radius;
    }

    @Override
    public float calculatePerimeter() {
        return 2*(float)Math.PI * this.radius;
    }

    @Override
    public void draw() {
        System.out.printf("Drawing a circle with the radius: " + this.radius);
    }

    @Override
    public Color lineColor() {
        return null;
    }
}
