
/**
 * Write a description of class Creature here.
 *
 * @author (Alex Gulewich)
 * @version (Feb, 6, 2021)
 */
import java.awt.*;

public class Creature {
    int x, y, width, height, speed, antiGravity;
    boolean notJumping = true;
    Color color;
    public Creature (int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}
