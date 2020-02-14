package Project018;

import HelperPackage.Node;

/**By starting at the top of the triangle below and moving to adjacent
 * numbers on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 * @author ndriqa
 * */

public class MaximumPathSumI {
    int maximum;
    int[][] pyramidVals;
    Node[][] pyramid;

    public MaximumPathSumI(){
        initializePyramid();
    }
    public void initializePyramid(){
        pyramidVals = new int[][]{
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        int hierarchyLevels = pyramidVals.length;
        pyramid = new Node[hierarchyLevels][];

        for (int i = 0; i < hierarchyLevels; i++) {
            pyramid[i] = new Node[pyramidVals[i].length];
            for (int j = 0; j < pyramidVals[i].length; j++) {
                pyramid[i][j] = new Node(pyramidVals[i][j]);
            }
        }
    }

    public void calculate(){
        //we know that border left and border right nodes have only one previous node
        //which means we calculate their distances first
        int hierarchyLevels = pyramid.length;
        //the first node doesn't have a previous node, hence the distance is its value
        pyramid[0][0].setDistance(pyramid[0][0].getValue());

        for (int i = 1; i < hierarchyLevels; i++) {
            pyramid[i][0].setDistance(pyramid[i-1][0].getDistance() + pyramid[i][0].getValue());
            pyramid[i][0].setPrevious(pyramid[i-1][0]);

            pyramid[i][i].setDistance(pyramid[i-1][i-1].getDistance() + pyramid[i][i].getValue());
            pyramid[i][i].setPrevious(pyramid[i-1][i-1]);
        }

        for (int i = 2; i < hierarchyLevels; i++) {
            for (int j = 1; j < pyramid[i].length - 1; j++) {
                int LEFT = pyramid[i][j].getValue() + pyramid[i-1][j-1].getDistance();
                int RIGHT = pyramid[i][j].getValue() + pyramid[i-1][j].getDistance();

                if (LEFT > RIGHT){
                    pyramid[i][j].setDistance(LEFT);
                    pyramid[i][j].setPrevious(pyramid[i-1][j-1]);
                } else {
                    pyramid[i][j].setDistance(RIGHT);
                    pyramid[i][j].setPrevious(pyramid[i-1][j]);
                }
            }
        }

        for (int i = 0; i < hierarchyLevels; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print("-" + pyramid[i][j].getDistance() + "-");
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        int longest = 0;
        for (int i = 0; i < pyramid[pyramid.length - 1].length - 1; i++) {
            if (pyramid[pyramid.length-1][i].getDistance() > longest){
                longest = pyramid[pyramid.length-1][i].getDistance();
            }
        }
        return "Maximum total distance from top to bottom is: " + longest;
    }

    public static void main(String[] args) {
        MaximumPathSumI max = new MaximumPathSumI();
        max.calculate();
        System.out.println(max);
    }
}
