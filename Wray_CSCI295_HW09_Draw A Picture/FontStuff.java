import javafx.scene.text.Font;

public class FontStuff {
    public static void main(String[] args) {
        
        // List the name of all font families
        for(String s : Font.getFamilies()){
            System.out.println(s);
        }
        
        // Pick one and look at its fonts
        String fam = "Times";
        System.out.println("\nFont names for " + fam);
        for(String s : Font.getFontNames(fam)){
            System.out.println(s);
        }
        
    }
}