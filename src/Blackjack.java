import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Blackjack extends JFrame{
    public static void main(String[] args) {
        Blackjack frame = new Blackjack();
        frame.setSize(600, 600);
        frame.setTitle("Black Jack");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public Blackjack(){
        Card c = new Card();
        setLayout(new FlowLayout());
        
        ImageIcon i = new ImageIcon("images/1.png");
        JButton iButton = new JButton(i);
        iButton.setBorderPainted(false); 
        iButton.setContentAreaFilled(false); 
        iButton.setFocusPainted(false); 
        iButton.setOpaque(false);
        
        //add(new Card(1));
        add(iButton);
    }
}