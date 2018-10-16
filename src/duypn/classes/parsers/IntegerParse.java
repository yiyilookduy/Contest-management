package duypn.classes.parsers;

public class IntegerParse {
    public static boolean tryParse(String source){
        try {
            Integer.parseInt(source);
        } catch (NumberFormatException exception){
            return false;
        }
        return true;
    }
}
