import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth =360;
        int boardHeight =640;

        JFrame frame= new JFrame("Flappy Bird");
       // frame.setVisible(true);  we comment that line because when we want to set our window after add all the settings
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        flappybird flappybird = new flappybird();
        frame.add (flappybird);
        frame.pack();
        flappybird.requestFocus();
        frame.setVisible(true); // so only we've added the jpannel to our frame we will set the visibility is true
    }
}
