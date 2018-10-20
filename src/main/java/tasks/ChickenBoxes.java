package tasks;

public class ChickenBoxes {


    // O(n)
    public static int[] calculateBoxes2(Integer[] boxes, int nuggets) {
        int[] result = new int[boxes.length];
        int currentBox = 0;
        while (nuggets > 0) {
            if ((currentBox == (boxes.length - 1) && nuggets < boxes[currentBox]) ||
                    (currentBox <= (boxes.length - 1) && (nuggets >= boxes[currentBox] || (nuggets < boxes[currentBox] && nuggets > boxes[currentBox + 1])))) {
                result[currentBox]++;
                nuggets -= (nuggets >= boxes[currentBox]) ? boxes[currentBox] : nuggets;
                continue;
            }
            currentBox++;
        }
        return result;
    }

    // O(1)
    public static int[] calculateBoxes(Integer[] boxes, int nuggets) {
        int[] result = new int[boxes.length];

        for (int i = 0; i < boxes.length; i++) {
            result[i] = nuggets / boxes[i];
            nuggets -= result[i] * boxes[i];
            if (i < (boxes.length - 1) && nuggets > boxes[i + 1]) {
                result[i]++;
                nuggets = 0;
                break;
            }
        }
        if (nuggets > 0) {
            result[boxes.length - 1]++;
        }

        return result;
    }
}
