import java.awt.*;

public class Rectangle extends shape{
    private float width;
    private float height;

    Rectangle(float w, float h){
        this.width = w;
        this.height = h;
    }

    @Override
    public float calculateArea() {
        return this.width * this.height;
    }

    @Override
    public float calculatePerimeter() {
        return this.width * 2 + this.height * 2;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width=" + this.width + " height=" + this.height);
    }

    @Override
    public Color lineColor() {
        return null;
    }
}
