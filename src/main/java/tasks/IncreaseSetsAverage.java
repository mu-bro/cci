package tasks;

import java.util.List;

public class IncreaseSetsAverage {

    public static boolean apply(List<Integer> list1, List<Integer> list2) {
        double avg1 = calculateAverage(list1);
        double avg2 = calculateAverage(list2);

        if (avg1 > avg2) {
            moveItem(list1, avg1, list2, avg2);
        } else {
            moveItem(list2, avg2, list1, avg1);
        }

        return calculateAverage(list1) > avg1 && calculateAverage(list2) > avg2;
    }

    private static double calculateAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    private static void moveItem(List<Integer> biggerList, double biggerAvg, List<Integer> smallerList, double smallerAvg) {
        int itemToMove;
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < biggerList.size() && biggerList.get(i) < biggerAvg; i++) {
            itemToMove = biggerList.get(i);
            if (itemToMove > smallerAvg) {
                index = i;
                break;
            }
        }
        smallerList.add(biggerList.get(index));
        biggerList.remove(index);
    }


}
