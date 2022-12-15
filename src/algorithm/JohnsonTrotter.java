package algorithm;

import java.util.ArrayList;

public class JohnsonTrotter {
    public static void main(String[] args) {
        ArrayList<int[]> a = johnsonTrotter(3);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).length; j++) {
                System.out.print(a.get(i)[j]);
            }
            System.out.println();
        }

    }
    public static ArrayList<int[]> johnsonTrotter(int n) {
        int k = n;
        int[] sequence = new int[n];
        Boolean[] arrow= new Boolean[n];
        ArrayList<int[]> result = new ArrayList<int[]>();


        for (int i = 1; i <= n; i++) {
            sequence[i - 1] = i;
            arrow[i - 1] = true;
        }
        result.add(sequence.clone());




        while (k != -1) {
            for (int i = 0; i < n; i++) {
                if (sequence[i] == k) {
                    int index;
                    if (arrow[i]) {
                        index = i - 1;
                    } else {
                        index = i + 1;
                    }
                    int tempNum = sequence[index];
                    Boolean tempArrow = arrow[index];
                    sequence[index] = sequence[i];
                    arrow[index] = arrow[i];
                    sequence[i] = tempNum;
                    arrow[i] = tempArrow;
                    break;
                }
            }




            for (int i = 0; i < n; i++) {
                if (sequence[i] > k) {
                    arrow[i] = !arrow[i];
                }
            }
            result.add(sequence.clone());
            k = Mobile_number(sequence, arrow, n);
        }

        return result;
    }


    public static int Mobile_number(int[] number, Boolean[] arrow, int n) {
        int k = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (!arrow[i] && (number[i] > number[i + 1])) {
                    if (number[i] > k)
                        k = number[i];
                }



            } else if (i != n - 1) {
                if ((arrow[i] && (number[i] > number[i - 1]))
                        || (!arrow[i] && (number[i] > number[i + 1]))) {
                    if (number[i] > k)
                        k = number[i];
                }



            } else {
                if (arrow[i] && (number[i] > number[i - 1])) {
                    if (number[i] > k)
                        k = number[i];
                }
            }
        }
        return k;
    }
}
