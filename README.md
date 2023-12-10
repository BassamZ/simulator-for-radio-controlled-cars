# Simulator for radio controlled cars
This project is a simulator for radio controlled cars implemented by Java.

## Description
YES! Our Company has been selected by one of the world’s best producers of radio controlled cars to create their new simulator which is to be used to test their cars. And you will be responsible for it!

The simulator will test various commands and see if the radio controlled cars can execute them without hitting the wall. The company has a wide range of cars, Monster Trucks, Off-road and Sport track, but for now they only want to simulate the Monster Truck. The simulator should be a console application.
The commands that the simulator should accept is forward, back, left and right. Forward will make the car move forward 1 meter, back will make the car move backwards 1 meter, left will rotate the car 90° counter clockwise and right will rotate the car 90° clockwise.
The simulated environment should be a room. The room size should be in whole meters (no decimals). The simulated car can be treated as a round object with 1 meter in diameter. The coordinate [0,0] is the most southwest point in which the car will fit.

When started the simulator should:
Ask the user about the size of the room.
This is inputted with two integers separated with a space.
Ask the user about starting position and heading of the RC car.
This is inputted with two integers and one letter separated with spaces. The letter can be N, S, W or E.
Ask the user about the commands to execute.
This is inputted with all commands in series. Available commands are F, B, L or R.
And then it should run the simulation to see if the car can run without hitting any walls.

## Sample Input
```
Enter the size of the room (width height) like (4 4): 
8 6
Enter the position of the car and heading of the car (AxisX AxisY Heading) like (2 3 N) or (2 3 n): 
2 3 n
Enter the execute command like (FBLR) or (fblr): 
fffrfflbb
```
## Sample Output
```
Car drives unsuccessfully. The last position and heading of the car is 2 5 N' before hitting the wall. By driving Forward in the command that has index 3 from execute command, the new position and heading of the car is 2 6 N which is out of the room(hitting the wall).
```
## Programming language
* Java

## IDE
* Intelij Community Edition

## Platform
* Windows Platform

## Author
* **Hiq Test**
  
## Solved by
* **Bassam Zabad**
