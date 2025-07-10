package google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrossMatrix {

    public static void main(String[] args) {


        List<List<Integer>> matrix = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        ));

        int size = matrix.size()-1;
        int result = 0;
        for(int i=0; i<matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            System.out.println(row.get(i));

            result += row.get(i) - row.get(size-i);


        }
        System.out.println(result);

    }
}
