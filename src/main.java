import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class main {
    public static void main(String[] args) {
    }

    static boolean matches(String source, String target) {
        int max = source.length();
        char first = target.charAt(0);
        for (int i = 0; i < max; i++) {
            if (source.charAt(i) != first) {
                while (++i < max && source.charAt(i) != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = i + target.length();
                for (int k = 1; j < end && source.charAt(j) == target.charAt(k); j++, k++) ;
                if (j == end) {
                    return true;
                }
            }
        }
        return false;
    }
}