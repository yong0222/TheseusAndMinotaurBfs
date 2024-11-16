package org.example;

import org.example.stub.DataSet;
import org.example.stub.TestData;

public class Main {

    public static void main(String[] args) {
        DataSet dataSet = TestData.puzzle7;

        Solution solution = new Solution(
                dataSet.getLabyrinth(),
                dataSet.getEscapeCoord(),
                dataSet.getTheseus(),
                dataSet.getMinotaur()
        );

        System.out.println(solution.bfsSolution());
    }

}
