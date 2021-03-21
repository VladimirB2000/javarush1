package com.javarush.task.task23.task2312;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }


    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public Snake(int x, int y){
        SnakeSection hedSnake = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(hedSnake);
        isAlive = true;
    }
    int getX(){
        return sections.get(0).getX();
    }
    int getY(){
        return sections.get(0).getY();
    }

    void move(){
        if (isAlive){
            if(direction == SnakeDirection.UP){
                move(0, -1);
            } else if (direction == SnakeDirection.RIGHT){
                move(1,0);
            } else if (direction == SnakeDirection.DOWN){
                move(0, 1);
            } else if(direction == SnakeDirection.LEFT){
                move(-1, 0);
            }
        }

    }
    void move(int x, int y){
        SnakeSection head = new SnakeSection(getX()+x, getY()+y);
        checkBorders(head);
        checkBody(head);
        if(Room.game.getMouse().getX() == head.getX() &&
                Room.game.getMouse().getY() == head.getY()){
            Room.game.eatMouse();
            sections.add(head);
        } else {
            sections.add(0, head);
            sections.remove(sections.size()-1);
        }

    }
    public void checkBorders(SnakeSection head){
        if(head.getX()<0 ||
                head.getY()<0 ||
                head.getX()>=Room.game.getWidth() ||
                head.getY()>=Room.game.getHeight())
            isAlive=false;
    }
    void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive = false;
        }
    }


}
