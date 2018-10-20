package tasks.firstTime;

public class Chapter6 {

    public static boolean[] getAllPrimes(int max) {
        boolean[] flags = new boolean[max + 1];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = true;
        }
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        for(int i = 0;i < flags.length; i++) {
        if (flags[i] == true) {
            System.out.print(i + " ");
        }
    }
        return flags;
}

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    private static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }



}


