
public class Blackjack {
    public static void main(String[] args) {
        //javax.swing.JOptionPane.showMessageDialog(null, new Blackjack().test());
        //javax.swing.JOptionPane.showMessageDialog(null, Constants.IMGDIR);
        //java.io.File f = new java.io.File(Constants.IMGDIR + "/1.png");
        //javax.swing.JOptionPane.showMessageDialog(null, f.exists());
        Game game = new Game();
        game.setVisible(true);
    }
}
