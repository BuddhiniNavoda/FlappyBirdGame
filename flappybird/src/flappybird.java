
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;  // to place the all the pipes
import java.util.Random; // to place the pipes in random position
import javax.swing.*;


public class flappybird extends JPanel implements ActionListener{
    int boardWidth =360;
    int boardHeight=640;

    // Images: 4 variables are to store our image 
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    
    //Bird (want to draw the bird on screen give x and y position as weight and height)
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdwidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdwidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }


    }

    //game logic
    Bird bird;
    int velocityY=-6;    // flapp bird  moving direction(upword=-y,downword=+y,forword=+x,backword=-x)
                        // flappy bird doesn't move forword or backfor it only upword and downword
                        // the first frame move up 6 pixel and the the next frame move up 6 pixel upword so this is going to 6 pixel upwords

    Timer gameLoop;


    flappybird(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
         
        //load Images : we want constructors to load our images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.jpeg" )).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.jpeg")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.jpeg")).getImage();
    
        //bird
        bird = new Bird(birdImg);

        //game timer
        gameLoop = new Timer(1000/60 ,this); // game loop is equal to new timer and need to specify how often shold repeat the action 
        // 1000/60 = so want 60 frames per second
        
        gameLoop.start();
    
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        draw(g);
    }


    public void draw(Graphics g){
        
        System.out.println("draw");


        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth,boardHeight,null); // we added a background image so(topleft corner-(0,0) and bottom right corner (360,640))
        
        //bird
        g.drawImage(bird.img,bird.x,bird.y ,bird.width,bird.height,null);
    
    }

    // update all the X and Y positions of objects
    public void move(){
        //bird
        bird.y += velocityY;

        bird.y =Math.max(bird.y, 0);  // bird is not allowed to move past the top part of screen(0 is the very top of the screen)

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       move(); // update the position of yje bird 
                // this action performed rund 60 times per second doing move then paint then move then paint over and over again every frame updating the bird's y position .
                // it's going to move upwards at a rate of 6 pixels per frame
        repaint(); 
    }
    
}
