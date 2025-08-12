public class Main {
    public static void main(String[] args) {
        // Variables
        int totalBoxes = 34;
        int truckCapacity = 9;
        int remainingBoxes = totalBoxes;
        int movesCount = 0;

        while (remainingBoxes > 0) {
            int boxesMoved;
            if (remainingBoxes > truckCapacity) {
                boxesMoved = truckCapacity;
            } else {
                boxesMoved = remainingBoxes;
            }
            remainingBoxes -= boxesMoved;
            movesCount++;
            System.out.printf("Voyage " + movesCount + " : " + boxesMoved + " cartons déplacés.");
        }
    }
}