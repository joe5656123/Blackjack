import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    private final Deck _deck;
    private Player _player;
    private Dealer _dealer;
    
    public Game() {
        // Set JFrame Properties
        this.setSize(600, 600);
        this.setTitle("Black Jack");
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        // Instansiate Cards
        this._deck = new Deck();
        
        // Configure Dealer
        this._dealer = new Dealer(this._deck);
        
        // Configure Player
        this._player = new Player(this._deck, this._dealer); // Adds the player panel
        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0)); // Green background
        this.add(this._player, BorderLayout.SOUTH); // Adds the player cards
        this.add(this._dealer, BorderLayout.NORTH); // Adds the dealers cards
    }
    
    public void restartGame() {
        this._dealer = new Dealer(this._deck);
        this._player = new Player(this._deck, this._dealer);
    }
    
    public Player getPlayer() {
        return this._player;
    }
}
