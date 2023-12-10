package RC;

import java.util.List;

public  abstract class RCsimulator {
    protected int carLastPositionX;
    protected int carLastPositionY;
    protected char carLastHeading;

    abstract protected void operation(InputData dataInput);

    abstract protected List<Integer> moveForward(int moveForwardDistance);

    abstract protected List<Integer> moveBackward(int moveBackwardDistance);

    abstract protected void turnRight(int rightRotationDegree);

    abstract protected void turnLeft(int leftRotationDegree );

    protected boolean isValidCarPosition(List<Integer> carPosition, int roomWidth, int roomHeight) {
        if (carPosition.get(0) >= 0 && carPosition.get(0) < roomWidth
                && carPosition.get(1) >= 0 && carPosition.get(1) < roomHeight) {
            return true;
        }
        return false;
    }

}
