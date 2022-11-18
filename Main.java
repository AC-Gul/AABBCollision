
/**
 * Write a description of class Main here.
 *
 * @author (Alex Gulewich)
 * @version (Feb, 17, 2020)
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Main extends JPanel implements ActionListener, KeyListener {
    Timer tm = new Timer(11, this);
    Creature player = new Creature(15, 10, 10, 25, Color.RED);
    static Creature[] platforms = new Creature[14];

       
    public Main () {
        addKeyListener(this);
        setFocusable(true);
        
    }
    
    
    public void keyPressed (KeyEvent KEY) {
        int input = KEY.getKeyCode();
        
        //Movement
        switch (input) {
            
            //Jump
            case (KeyEvent.VK_W):
                if (player.notJumping) {
                    player.antiGravity = 35;
                    player.notJumping = false;
                }
                break;
               
            //Move left
            case (KeyEvent.VK_A):
                player.speed = -1;
                break;
                
            //TBD
            case (KeyEvent.VK_S):
                break;
                
            //Move right
            case (KeyEvent.VK_D):
                player.speed = 1;
                break;
        }
    }
    
    
    public void keyReleased (KeyEvent KEY) {
        int input = KEY.getKeyCode();
        
        if (input == KeyEvent.VK_A || input == KeyEvent.VK_D) {
            player.speed = 0;
        }
    }
    
    
    //OVER-RIDE  NEEDS TO EXIST
    public void keyTyped (KeyEvent KEY) {}
    
    public void actionPerformed (ActionEvent e) {
        //Check for collisoins
        AABB.checkCollision(player, platforms);
        
        //Movement
        player.x += player.speed;
        if (player.antiGravity > 0) {
            player.y -= 4;
            player.antiGravity--;
        }
        
        repaint();
    }
    
   public void paintComponent (Graphics g) {
       super.paintComponent(g);
       Graphics2D g2D = (Graphics2D) g;
       
       //Print the world
        for (int x = 0; x < platforms.length; x++) {
            g2D.setColor(platforms[0].color);
            g2D.fillRect(platforms[x].x, platforms[x].y, platforms[x].width, platforms[x].height);
        }
        
       //Print the player
       g2D.setColor(Color.RED);
       g2D.fillRect(player.x, player.y, player.width, player.height);
       tm.start();
   }
    
    
   public static void main (String[] args) {
       //Declarations
        Main panel = new Main();
        JFrame window = new JFrame("AABBCollision");
   
        //Setup the screen
        window.setSize(500, 500);
        window.add(panel);
        window.setVisible(true);
        
        //Setup the game
        for (int a = 0; a < platforms.length; a++) {
            platforms[a] = new Creature(Map.x[a], Map.y[a], Map.width[a], Map.height[a], Color.BLACK);
        }
    }
}
