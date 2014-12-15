import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {
    private Stat _stat;
    private Deck _deck;
    private Player _player;
    private Dealer _dealer;
    
    
    private ExitListener _exitListener;
    private InputListener _inputListener;
    
    public Game() {
        // Set JFrame Properties
        this.setSize(600, 600);
        this.setTitle("Blackjack");
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setFocusable(true);
        
        // Instantiate Deck
        this._deck = new Deck();
        
        // Instantiate Dealer
        this._dealer = new Dealer(this);
        
        // Instantiate Player
        this._player = new Player(this);
        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Constants.BGCOLOR); // Green background
        this.add(this._player, BorderLayout.SOUTH); // Adds the player cards
        this.add(this._dealer, BorderLayout.NORTH); // Adds the dealers cards
        
        this._stat = new Stat();
        String name = null;
        while (name == null || name.trim().equals("")) {
            name = JOptionPane.showInputDialog(this, "Enter your name for the leaderboards!");
        }
        
        this._stat.name(name);
        this._stat.wins(0);
        this._stat.losses(0);
        
        // Add Listeners
        this._exitListener = new ExitListener(this._stat);
        this.addWindowListener(this._exitListener);
        
        this._inputListener = new InputListener(this);
        this.addKeyListener(this._inputListener);
    }
    
    public void restartGame() {
        this.remove(this._player);
        this.remove(this._dealer);
        
        this._dealer = new Dealer(this);
        this._player = new Player(this);
        
        this.add(this._dealer, BorderLayout.NORTH);
        this.add(this._player, BorderLayout.SOUTH);
        
        this.repaint();
        this.revalidate();
    }
    
    public Player getPlayer() {
        return this._player;
    }
    
    public Dealer getDealer() {
        return this._dealer;
    }
    
    public Deck getDeck() {
        return this._deck;
    }
    
    public void setColor(Color c) {
        this.getContentPane().setBackground(c);
        this._dealer.setBackground(c);
        this._player.setColor(c);
    }

    /**
    * Determines winner and displays a message via JOptionPane
    */
    public void determineWinner() {
        try {
        StringBuilder fullMessage = new StringBuilder();
        String message;
        if (this._player.getTotal() > 21) {
            message = "You busted!";
            this._stat.lose();
        } else if (this._player.getTotal() == 21) {
            message = "Blackjack! You win!";
            this._stat.win();
        } else if (this._dealer.getDealerScore() > 21) {
            message = "The dealer busted, you win!";
            this._stat.win();
        } else if (this._dealer.getDealerScore() == 21) {
            message = "The dealer has blackjack, you lose!";
            this._stat.lose();
        } else if (this._dealer.getDealerScore() > this._player.getTotal()) {
            message = "The dealer has more than you, you lose!";
            this._stat.lose();
        } else if (this._dealer.getDealerScore() == this._player.getTotal()) {
            message = "You tied!";
        }else {
            message = "You have more than the dealer, you win!";
            this._stat.win();
        }
        fullMessage.append(message);
        fullMessage.append("\nYour total: ").append(this._player.getTotal());
        fullMessage.append("\nDealer's total: ").append(this._dealer.getDealerScore());
        JOptionPane.showMessageDialog(this, fullMessage.toString());
        } catch (NullPointerException e) {
            this.restartGame();
        }
    }
    
    class ExitListener extends WindowAdapter {
        private Stat _stat;
        public ExitListener(Stat s) {
            this._stat = s;
        }
        @Override
        public void windowClosing(WindowEvent e) {
            // Before closing, write the statistics to file
            this._stat.writeToFile();
            System.exit(0);
        }
    }
        
    public class Funnable implements Runnable {
        private Game _game;
        
        public Funnable(Game g) {
            _game = g;
        }
        
        @Override
        public void run() {
            java.util.Random r = new java.util.Random();
            Color c;
            while (true) {
                c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                this._game.setColor(c);
                try { Thread.sleep(50); } catch (Exception ex) {}
            }
        }
    }
    
    class InputListener extends KeyAdapter {
        private Game _game;
        private boolean easterEgg;
        private Thread _thread;
        
        public InputListener (Game g) {
            this._game = g;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'l') {
                // Display Leaderboard Here!
                StatCollection sc = new StatCollection();
                sc.populateFromFile();
                Leaderboard l = new Leaderboard(sc);
                l.setVisible(true);
            } else if (e.getKeyChar() == 'e') {
                this.easterEgg = !this.easterEgg;
                if (this.easterEgg) {
                    this._thread = new Thread(new Funnable(this._game));
                    this._thread.start();
                } else {
                    // Calling Thread.stop() here because I want my thread to unsafely end!
                    this._thread.stop();
                    this._game.setColor(Constants.BGCOLOR);
                }
            }
        }        
    }
}
