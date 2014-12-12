
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Stat {
    private String _name;
    private int _wins;
    private int _losses;
    
    public Stat () {}
    public Stat (String n, int w, int l) {
        this._name = n;
        this._wins = w;
        this._losses = l;
    }
    
    // Trying a new thing here with the getters and setters
    // jquery uses this syntax; its quite interesting... ex:
    // Getter: string w = stat.wins();
    // Setter: stat.wins(w);
    
    public void name(String n) { this._name = n; }
    public String name() { return this._name; }
    
    public void wins(int w) { this._wins = w; }
    public int wins() { return this._wins; }
    
    public void losses(int l) { this._losses = l; }
    public int losses() { return this._losses; }
    
    public void win() { this._wins++; }
    public void lose() { this._losses++; }
    
    public void writeToFile() {
        File file = new File(Constants.STATDIR);
        if (!file.exists()) {
            try { file.createNewFile(); } catch (Exception ex) { return; }
        }
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Constants.STATDIR, true)))) {
            out.println(this._wins + " " + this._losses + " " + this._name);
        } catch (Exception e) {
            System.out.println("Failed to write to file!");
        }
    }
}

class StatCollection extends java.util.ArrayList<Stat> {
    public StatCollection() {}
    
    public void populateFromFile() {
        File file = new File(Constants.STATDIR);
        if (file.exists()) {
            try { 
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    String[] line = sc.nextLine().split(" ");
                    String name = line[2];
                    if (line.length > 3) {
                        for (int i = 3; i < line.length; i++) {
                            name += " " + line[i];
                        }
                    }
                    
                    // Populate Stat Object
                    Stat stat = new Stat();
                    stat.wins(Integer.parseInt(line[0]));
                    stat.losses(Integer.parseInt(line[1]));
                    stat.name(name);
                    this.add(stat);
                }
            } catch (Exception ex) { 
                System.out.println(
                    "You win ONE MILLION DOLLARS because I already checked to see if the file "
                    + "exists, but I still have to put this stupid try-catch here because Java..."
                );
            }
        } else {
            try { file.createNewFile(); } catch (Exception ex) { System.out.println("Error");}
        }
    }
}