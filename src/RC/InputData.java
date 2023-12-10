package RC;

import java.util.*;

 final public class InputData {
    private int roomWidth;
    private int roomHeight;

    private int carStartingPositionX;
    private int carStartingPositionY;

    private char carHeading;

    private String carExecuteCommand;

    public int getRoomWidth() {
        return roomWidth;
    }

    public int getRoomHeight() {
        return roomHeight;
    }

    public int getCarStartingPositionX() {
        return carStartingPositionX;
    }


    public int getCarStartingPositionY() {
        return carStartingPositionY;
    }

    public char getCarHeading() {
        return carHeading;
    }

    public String getCarExecuteCommand() {
        return carExecuteCommand;
    }

    public void setData() {
        this.setRoomSize();
        this.setCarPosition_Heading();
        this.setExecuteCommand();
    }

    private void setRoomSize() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the room (width height) like (4 4): ");

        String[] roomSize = scanner.nextLine().split(" ");

        if (roomSize.length == 2) {
            try {
                this.roomWidth = Integer.parseInt(roomSize[0]);
                this.roomHeight = Integer.parseInt(roomSize[1]);

                if (this.roomWidth <= 0 || this.roomHeight <= 0) {
                    throw new IllegalArgumentException("Invalid input. The size of the room should be two integers greater than 0 and separated by a space.");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid input. The size of the room should be two integers greater than 0 and separated by a space.");
            }
        } else {
            throw new IllegalArgumentException("Invalid input. The size of the room should be two integers greater than 0 and separated by a space.");
        }

    }

    private void setCarPosition_Heading() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the position of the car and heading of the car (AxisX AxisY Heading) like (2 3 N) or (2 3 n): ");

        String[] carCoordinator = scanner.nextLine().split(" ");

        if (carCoordinator.length == 3) {
            try {
                this.carStartingPositionX = Integer.parseInt(carCoordinator[0]);
                this.carStartingPositionY = Integer.parseInt(carCoordinator[1]);
                this.carHeading = carCoordinator[2].toUpperCase().charAt(0);

                if (this.carStartingPositionX < 0 || this.carStartingPositionY < 0) {
                    throw new IllegalArgumentException("Invalid input. The position of the car should be two integers equal or greater than 0 and separated by a space. Heading" +
                            " should be one of  letters (N,S,W,E) or (n,s,w,e) followed the position of the car and separated by space.");
                }

                if (this.carHeading != 'N' && this.carHeading != 'S' && this.carHeading != 'W' && this.carHeading != 'E') {
                    throw new IllegalArgumentException("Invalid input. The position of the car should be two integers equal or greater than 0 and separated by a space. Heading" +
                            " should be one of letters (N,S,W,E) or (n,s,w,e) followed the position of the car and separated by space.");
                }

            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid input. The position of the car should be two integers equal or greater than 0 and separated by a space. Heading" +
                        " should be one of letters (N,S,W,E) or (n,s,w,e) followed the position of the car and separated by space.");
            }
        } else {
            throw new IllegalArgumentException("Invalid input. The position of the car should be two integers equal or greater than 0 and separated by a space. Heading" +
                    " should be one of letters (N,S,W,E) or (n,s,w,e) followed the position of the car and separated by space.");
        }


    }

    private void setExecuteCommand() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the execute command like (FBLR) or (fblr): ");

        this.carExecuteCommand = scanner.next().toUpperCase();

        for (char command : carExecuteCommand.toCharArray()) {
            if (command != 'F' && command != 'B' && command != 'L' && command != 'R') {
                throw new IllegalArgumentException("Invalid Input. The Execute Commands should be string contained some of letters (F,B,L,R) or (fblr)");
            }
        }




    }





}
