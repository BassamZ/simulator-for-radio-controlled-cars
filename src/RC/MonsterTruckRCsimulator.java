package RC;

import java.util.ArrayList;
import java.util.List;


public class MonsterTruckRCsimulator extends RCsimulator {

    @Override
    protected void operation(InputData dataInput) {

        super.carLastPositionX = dataInput.getCarStartingPositionX();
        super.carLastPositionY = dataInput.getCarStartingPositionY();
        super.carLastHeading = dataInput.getCarHeading();
        String executecommand = dataInput.getCarExecuteCommand();
        List<Integer> newCarPosition;
        final int moveForwardDistance = 1;
        final int moveBackwardDistance = 1;
        int rightRotationDegree = 90;
        int leftRotationDegree = 90;
        int commandCount = 0;
        boolean collision = false;
        for (char command : executecommand.toCharArray()) {
            commandCount++;
            switch (command) {
                case 'F':
                    newCarPosition = moveForward(moveForwardDistance);
                    if (super.isValidCarPosition(newCarPosition, dataInput.getRoomWidth(), dataInput.getRoomHeight())) {
                        super.carLastPositionX = newCarPosition.get(0);
                        super.carLastPositionY = newCarPosition.get(1);
                    } else {
                        System.out.println("Car drives unsuccessfully. The last position and heading of the car is "
                                + super.carLastPositionX + " " + super.carLastPositionY + " " + super.carLastHeading +
                                "' before hitting the wall. By driving Forward in the command that has index " + commandCount +
                                " from execute command, the new position and heading of the car is " + newCarPosition.get(0) + " " + newCarPosition.get(1) +
                                " " + super.carLastHeading + " which is out of the room(hitting the wall).");
                        collision = true;
                    }
                    break;
                case 'B':
                    newCarPosition = moveBackward(moveBackwardDistance);
                    if (super.isValidCarPosition(newCarPosition, dataInput.getRoomWidth(), dataInput.getRoomHeight())) {
                        super.carLastPositionX = newCarPosition.get(0);
                        super.carLastPositionY = newCarPosition.get(1);
                    } else {
                        System.out.println("Car drives unsuccessfully. The last position and heading of the car is "
                                + super.carLastPositionX + " " + super.carLastPositionY + " " + super.carLastHeading +
                                "' before hitting the wall. By driving Backward in the command that has index " + commandCount +
                                " from execute command,  the new position and heading of the car is " + newCarPosition.get(0) + " " + newCarPosition.get(1) +
                                " " + super.carLastHeading + " which is out of the room(hitting the wall).");
                        collision = true;
                    }
                    break;
                case 'R':
                    turnRight(rightRotationDegree);
                    break;
                case 'L':
                    turnLeft(leftRotationDegree);
                    break;
            }
            if (collision) {
                break;
            }

        }

        if (!collision) {
            System.out.println("Car drives Successfully. The end position and heading of the car is " +
                    super.carLastPositionX + " " + super.carLastPositionY + " " + super.carLastHeading + ".");
        }
    }

    @Override
    protected List<Integer> moveForward(int moveForwardDistance) {
        List<Integer> newCarPosition = new ArrayList<>(2);
        newCarPosition.add(0, super.carLastPositionX);
        newCarPosition.add(1, super.carLastPositionY);


        switch (super.carLastHeading) {
            case 'N':
                newCarPosition.set(1, newCarPosition.get(1) + moveForwardDistance);
                break;
            case 'S':
                newCarPosition.set(1, newCarPosition.get(1) - moveForwardDistance);
                break;
            case 'W':
                newCarPosition.set(0, newCarPosition.get(0) - moveForwardDistance);
                break;
            case 'E':
                newCarPosition.set(0, newCarPosition.get(0) + moveForwardDistance);
                break;
        }

        return newCarPosition;
    }

    @Override
    protected List<Integer> moveBackward(int moveBackwardDistance) {
        List<Integer> newCarPosition = new ArrayList<>(2);
        newCarPosition.add(0, super.carLastPositionX);
        newCarPosition.add(1, super.carLastPositionY);


        switch (super.carLastHeading) {
            case 'N':
                newCarPosition.set(1, newCarPosition.get(1) - moveBackwardDistance);
                break;
            case 'S':
                newCarPosition.set(1, newCarPosition.get(1) + moveBackwardDistance);
                break;
            case 'W':
                newCarPosition.set(0, newCarPosition.get(0) + moveBackwardDistance);
                break;
            case 'E':
                newCarPosition.set(0, newCarPosition.get(0) - moveBackwardDistance);
                break;
        }


        return newCarPosition;
    }

    @Override
    protected void turnRight(int rightRotationDegree) {

        switch (rightRotationDegree) {
            case 90:
                switch (super.carLastHeading) {
                    case 'N':
                        super.carLastHeading = 'E';
                        break;
                    case 'S':
                        super.carLastHeading = 'W';
                        break;
                    case 'W':
                        super.carLastHeading = 'N';
                        break;
                    case 'E':
                        super.carLastHeading = 'S';
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid Input. Right Rotation Degree should be 90.");
        }


    }

    @Override
    protected void turnLeft(int leftRotationDegree) {

        switch (leftRotationDegree) {
            case 90:
                switch (super.carLastHeading) {
                    case 'N':
                        super.carLastHeading = 'W';
                        break;
                    case 'S':
                        super.carLastHeading = 'E';
                        break;
                    case 'W':
                        super.carLastHeading = 'S';
                        break;
                    case 'E':
                        super.carLastHeading = 'N';
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid Input. Left Rotation Degree should be 90.");
        }


    }

}
