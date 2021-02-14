import java.util.LinkedList;
import java.util.Queue;

class Pair implements Comparable<Pair> {
    int xAxis;
    int yAxis;

    public Pair(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public int compareTo(Pair o) {
        return yAxis - o.yAxis;
    }
}

class FloodFillAlgorithm {
    public static boolean validCoord(int xCoordOnMatrix, int yCoordOnMatrix, int horizontalSizeOfMatrix, int verticalSizeOfMatrix) {
        return xCoordOnMatrix < horizontalSizeOfMatrix && yCoordOnMatrix < verticalSizeOfMatrix && xCoordOnMatrix > 0 && yCoordOnMatrix > 0;
    }

    // Function to run bfs
    public static void bfsApproachAlgorithm(int horizontalSizeOfMatrix, int verticalSizeOfMatrix, int[][] matrixOfData, int xCoordinateToReplace, int yCoordinateToReplace, int newColorNumber) {
        int[][] visitingArray = new int[horizontalSizeOfMatrix + 1][verticalSizeOfMatrix + 1];

        for (int i = 0; i <= horizontalSizeOfMatrix; i++) {
            for (int j = 0; j <= verticalSizeOfMatrix; j++) {
                visitingArray[i][j] = 0;
            }
        }

        // Creating queue for bfs
        Queue<Pair> objectsToBeChecked = new LinkedList<>();

        Pair pairWithInitialCoordinates = new Pair(xCoordinateToReplace, yCoordinateToReplace);
        objectsToBeChecked.add(pairWithInitialCoordinates);

        // Marking {x, y} as visited
        visitingArray[xCoordinateToReplace][yCoordinateToReplace] = 1;

        while (!objectsToBeChecked.isEmpty()) {
            // Extrating front pair
            Pair actualCoordinate = objectsToBeChecked.peek();
            int xCoordtinateActualPair = actualCoordinate.xAxis;
            int yCoordtinateActualPair = actualCoordinate.yAxis;
            int actualColorOnCoordinate = matrixOfData[xCoordtinateActualPair][yCoordtinateActualPair];

            matrixOfData[xCoordtinateActualPair][yCoordtinateActualPair] = newColorNumber;

            objectsToBeChecked.remove();

            // For Upside Pixel or Cell
            if (validCoord(xCoordtinateActualPair + 1, yCoordtinateActualPair, horizontalSizeOfMatrix, verticalSizeOfMatrix) && checkIfIsValidToReplaceColor(visitingArray, matrixOfData, xCoordtinateActualPair + 1, yCoordtinateActualPair, actualColorOnCoordinate)) {
                Pair p = new Pair(xCoordtinateActualPair + 1, yCoordtinateActualPair);
                objectsToBeChecked.add(p);
                visitingArray[xCoordtinateActualPair + 1][yCoordtinateActualPair] = 1;
            }

            // For Downside Pixel or Cell
            if ((validCoord(xCoordtinateActualPair - 1, yCoordtinateActualPair, horizontalSizeOfMatrix, verticalSizeOfMatrix)) && checkIfIsValidToReplaceColor(visitingArray, matrixOfData, xCoordtinateActualPair - 1, yCoordtinateActualPair, actualColorOnCoordinate)) {
                Pair p = new Pair(xCoordtinateActualPair - 1, yCoordtinateActualPair);
                objectsToBeChecked.add(p);
                visitingArray[xCoordtinateActualPair - 1][yCoordtinateActualPair] = 1;
            }

            // For Right side Pixel or Cell
            if ((validCoord(xCoordtinateActualPair, yCoordtinateActualPair + 1, horizontalSizeOfMatrix, verticalSizeOfMatrix)) && checkIfIsValidToReplaceColor(visitingArray, matrixOfData, xCoordtinateActualPair, yCoordtinateActualPair + 1, actualColorOnCoordinate)) {
                Pair p = new Pair(xCoordtinateActualPair, yCoordtinateActualPair + 1);
                objectsToBeChecked.add(p);
                visitingArray[xCoordtinateActualPair][yCoordtinateActualPair + 1] = 1;
            }

            // For Left side Pixel or Cell
            if ((validCoord(xCoordtinateActualPair, yCoordtinateActualPair - 1, horizontalSizeOfMatrix, verticalSizeOfMatrix)) && checkIfIsValidToReplaceColor(visitingArray, matrixOfData, xCoordtinateActualPair, yCoordtinateActualPair - 1, actualColorOnCoordinate)) {
                Pair p = new Pair(xCoordtinateActualPair, yCoordtinateActualPair - 1);
                objectsToBeChecked.add(p);
                visitingArray[xCoordtinateActualPair][yCoordtinateActualPair - 1] = 1;
            }
        }

        // Printing The Changed Matrix Of Pixels
        for (int i = 0; i < horizontalSizeOfMatrix; i++) {
            for (int j = 0; j < verticalSizeOfMatrix; j++) {
                System.out.print(matrixOfData[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean checkIfIsValidToReplaceColor(int[][] visitingArray, int[][] matrixOfData, int xCoordtinateActualPair, int yCoordtinateActualPair, int actualColorOnCoordinate) {
        return visitingArray[xCoordtinateActualPair][yCoordtinateActualPair] == 0 && matrixOfData[xCoordtinateActualPair][yCoordtinateActualPair] == actualColorOnCoordinate;
    }

    public static void main(String[] args) {
        int horizontalSizeOfMatrix = 8;
        int verticalSizeOfMatrix = 8;

        int[][] matrixOfData = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},};

        int xCoordinateToReplace = 0;
        int yCoordinateToReplace = 3;
        int newColorNumber = 8;

        bfsApproachAlgorithm(horizontalSizeOfMatrix, verticalSizeOfMatrix, matrixOfData, xCoordinateToReplace, yCoordinateToReplace, newColorNumber);
    }
}