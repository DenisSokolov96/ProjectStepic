package org.denis.robotGame;

import org.w3c.dom.ls.LSOutput;

public class Main /*implements RobotConnection*/ {

    private static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {

        robotFunc();
    }

    public static void robotFunc() {
        Robot robot = new Robot();
        int toX = 21;
        int toY = 21;
        //для пошаговых инструция
        //moveRobot(robot, toX, toY);

        RobotConnectionManager robotConnectionManager = new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return null;//вернуть соеденение
            }
        };
        //с использованием интерфейсов
        moveRobot(robotConnectionManager,toX,toY);

        str.append("Робот прибыл в точку (x,y): " + robot.getX() + "," + robot.getY());
        System.out.println(str);
        str.setLength(0);
    }


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int countConnection = 0;
        while (countConnection<3) {
            countConnection++;

            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {

                robotConnection.moveRobotTo(toX,toY);

                countConnection = 4;

            }catch (RobotConnectionException e) {

                if (countConnection == 3)
                    throw new RobotConnectionException("Ошибка подключения после 3-х попыток.",e);
            } catch (Throwable e) {

                throw e;
            }

        }
    }



    // пошаговая инструкция
    /*public static void moveRobot(Robot robot,int toX, int toY) {

        int x = robot.getX();
        int y = robot.getY();
        Direction direction = robot.getDirection();

        if (y < toY) {

            switch (direction){
                case UP: break;
                case DOWN: robot.turnRight(); robot.turnRight(); break;
                case LEFT: robot.turnRight(); break;
                case RIGHT: robot.turnLeft(); break;
            }

            for (int i  = 0 ; i < Math.abs(toY - y); i++ ) {
                robot.stepForward();
            }
        } else if (y > toY) {
            switch (direction){
                case UP: robot.turnRight(); robot.turnRight(); break;
                case DOWN: break;
                case LEFT: robot.turnLeft(); break;
                case RIGHT: robot.turnRight(); break;
            }
            for (int i  = 0 ; i < Math.abs(toY - y); i++ ) {
                robot.stepForward();
            }
        }

        if ( (x < toX) && (robot.getDirection() == Direction.UP) ) {
            robot.turnRight();
            for (int i  = 0 ; i< Math.abs(toX - x); i++ ) {
                robot.stepForward();
            }
            return;
        }
        if ( (x < toX) && (robot.getDirection() == Direction.DOWN) ) {
            robot.turnLeft();
            for (int i  = 0 ; i< Math.abs(toX - x); i++ ) {
                robot.stepForward();
            }

            return;
        }

        if ( (x > toX) && (robot.getDirection() == Direction.UP) ) {
            robot.turnLeft();
            for (int i  = 0 ; i< Math.abs(toX - x); i++ ) {
                robot.stepForward();
            }
            return;
        }

        if ( (x > toX) && (robot.getDirection() == Direction.DOWN) ) {
            robot.turnRight();
            for (int i  = 0 ; i< Math.abs(toX - x); i++ ) {
                robot.stepForward();
            }
            return;
        }

    }*/

}
