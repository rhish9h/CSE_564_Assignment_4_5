import java.awt.*;

public class ClassBox {
    private Rectangle rectangle;
    private String className;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 30;
    public ClassBox(String className, int x, int y) {
        rectangle = new Rectangle(x - (WIDTH / 2), y - (HEIGHT / 2), WIDTH, HEIGHT);
        this.className = className;
    }

    public void draw(Graphics graphics) {
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(rectangle.x + 1, rectangle.y + 1, rectangle.width - 1, rectangle.height - 1);
        graphics.setColor(Color.BLACK);
        graphics.drawString(className, rectangle.x + 2, rectangle.y + HEIGHT / 4 * 3);
        graphics.setColor(c);
    }
}
