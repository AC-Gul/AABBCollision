
/**
 * Write a description of class AABB here.
 *
 * @author (Alex Gulewich)
 * @version (Feb, 7, 2021)
 */
public class AABB
{
    public static void checkCollision (Creature self, Creature[] other) {
        
        boolean falling = true;
        //Check for collisions
        for (int x = 0; x < other.length; x++) {
            //Top face against bottom face
            if (self.x + self.width > other[x].x && self.y == other[x].y + other[x].height && self.x  < other[x].x + other[x].width) {
                self.antiGravity = 0;
            }
            
            //Left face against right face
            if (self.y + self.height > other[x].y && self.x + self.width == other[x].x && self.y < other[x].y + other[x].height) {
                self.x--;
            }
            
            //Bottom face against top face
            if (self.x + self.width > Main.platforms[x].x && self.y + self.height >= other[x].y && self.y + self.height < other[x].y + other[x].height && self.x  < other[x].x + other[x].width) {
                self.notJumping = true;
                falling = false;
            }
            
            //Right face against left face
            if (self.y + self.height  > other[x].y && self.x == other[x].x + other[x].width && self.y < other[x].y + other[x].height) {
                self.x++;
            }
        }
        
        //Prevents indefinate falling
        if (falling) {
            self.y += 2;
        }
    }
}