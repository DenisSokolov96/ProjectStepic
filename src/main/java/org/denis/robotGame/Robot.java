package org.denis.robotGame;

public class Robot {

    private int x = 0;
    private int y = 40;
    private int countStep = 0;
    Direction direction = Direction.UP;

    private StringBuilder str = new StringBuilder();

    public Direction getDirection() {
        return this.direction;
    }

    public int getX() { return this.x; }

    public int getY() {
        return this.y;
    }

    /*****для задачи с установлением связи******/
    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
    /*****************************************/

    public void turnLeft() {
        str.append("Поворот против часовой стрелки: ");
        switch (direction){
            case UP: this.direction = Direction.LEFT; str.append("вверх --> влево"); break;
            case DOWN: this.direction = Direction.RIGHT; str.append("вниз --> вправо"); break;
            case LEFT: this.direction = Direction.DOWN; str.append("влево --> вниз"); break;
            case RIGHT: this.direction = Direction.UP; str.append("вправо --> вверх"); break;
        }
        System.out.println(str);
        str.setLength(0);
    }

    public void turnRight() {
        str.append("Поворот по часовой стрелке: ");
        switch (direction){
            case UP: this.direction = Direction.RIGHT; str.append("вверх --> вправо"); break;
            case DOWN: this.direction = Direction.LEFT; str.append("вниз --> влево"); break;
            case LEFT: this.direction = Direction.UP; str.append("влево --> вверх"); break;
            case RIGHT: this.direction = Direction.DOWN; str.append("вправо --> вниз"); break;
        }
        System.out.println(str);
        str.setLength(0);
    }

    public void stepForward() {
        this.countStep++;
        str.append(this.countStep + ") шаг ");
        switch (direction){
            case UP: this.y++; str.append("вверх"); break;
            case DOWN: this.y--; str.append("вниз"); break;
            case LEFT: this.x--; str.append("влево"); break;
            case RIGHT: this.x++; str.append("вправо"); break;
        }
        System.out.println(str);
        str.setLength(0);
    }
}