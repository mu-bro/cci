package tasks.firstTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chapter8 {

    private int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private int fibonacci2(int n) {
        if (n == 0) return 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public static List<String> getPerms(String s) {
        if (s.length() == 1) return Collections.singletonList(s);

        char firstElem = s.charAt(0);
        String prefix = s.substring(1, s.length());
        return getPerms(firstElem, prefix);
    }

    private static List<String> getPerms(char s, String prefix) {
        List<String> result = new ArrayList<>();

        List<String> perms = getPerms(prefix);
        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                String newPerm = perm.substring(0, i) + s + perm.substring(i, perm.length());
                result.add(newPerm);
            }
        }
        return result;
    }


}


