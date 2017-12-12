package utility;

/**
 * Created by WifiMorfi on 12/12/2017.
 */
public class TextUtils {
    static boolean isEmpty (String s){
        if (s.length() == 0){
            return true;
        }
        if (s == null)
            return true;
        if (s.equals("null"))
            return true;
        if (s.equals("NULL"))
            return true;
        return false;
    }
}
