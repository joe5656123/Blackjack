
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joe
 */
public class Constants {
    public static String IMGDIR = calculateImageDirectory();
    public static String STATDIR = calculateFilePath();
    
    /**
     * Calculates the image directory.
     * Netbeans sees the directory as src\images, however
     * other programs which use the command line 'javac' will
     * see it as simply 'images'
     * TODO: Fix so it works with jars too
     * @return A String path to the images folder
     */
    private static String calculateImageDirectory() {
        /*
        String basePath = (new File(".")).getAbsolutePath();
        basePath = basePath.substring(0, basePath.length()-1);
        */
        java.io.File file = new java.io.File("src");
        if (file.isDirectory()) {
            return "src\\images";
            //return basePath + "src\\images";
        } else {
            return "images";
            //return basePath + "images";
        }
    }
    
    /**
     * Calculates the Stats.txt directory
     * @return A String path to the stats file
     */
    private static String calculateFilePath() {
        java.io.File file = new java.io.File("src");
        if (file.isDirectory()) {
            return "src/Stats.txt";
        } else {
            return "Stats.txt";
        }
    }
}
