package com.enigma.model;

import java.util.Arrays;

public class Robot {
        private Integer postX;
        private Integer postY;
        char [] commands;
        //konstanta
        private final String RIGHT = "R";
        private final String LEFT = "L";
        private final String FORWARD = "F";
        private final String BACK = "B";
        Direction direction;


    public Robot(Integer x, Integer y, Direction direction) {
        this.postX =x;
        this.postY = y;
        this.direction=direction;
    }
    public void commands(String gerak) {
        for (int i = 0; i < gerak.length(); i++) {
            this.commands = gerak.toUpperCase().toCharArray();
        }
    }

    public void turnRight(){
        this.direction=this.direction.getRight();
    }

    public void turnLeft(){
        this.direction=this.direction.getLeft();
    }
    public void forward(){
        if (direction.equals(Direction.NORTH)){
            this.postY++;
            this.direction = Direction.NORTH;
        }else if(direction.equals(Direction.WEST)){
            this.postX--;
            this.direction = Direction.WEST;
        }else if(direction.equals(Direction.EAST)){
            this.postX++;
            this.direction = Direction.EAST;
        }else if(direction.equals(Direction.SOUTH)) {
            this.postY--;
            this.direction = Direction.SOUTH;
        }else{
            System.out.println("ARAH YANG ANDA MASUKAN SALAH!");
        }
    }

    public void backward(){
        if (direction.equals( Direction.NORTH)){
            this.postY--;
            this.direction = Direction.NORTH;
        }else if(direction.equals(Direction.WEST)){
            this.postX++;
            this.direction = Direction.WEST;
        }else if(direction.equals(Direction.EAST)){
            this.postX--;
            this.direction = Direction.EAST;
        }else if(direction.equals(Direction.SOUTH)){
            this.postY++;
            this.direction = Direction.SOUTH;
        }else{
            System.out.println("Inputan arah anda salah");
        }
    }

    public void move(String movement,Direction direction) {
        switch(movement) {
            case RIGHT :
                turnRight();
                break;
            case LEFT :
                turnLeft();
                break;
            case FORWARD :
                forward();
                break;
            case BACK :
                backward();
            default :
                System.out.println("Salah input gerakan : "+movement+"");
                System.exit(0);
        }
    }

    public void run(){

        for (int i = 0; i < this.commands.length; i++) {
            move(String.valueOf(this.commands[i]),this.direction);
            System.out.println(this.commands[i] + getPotition()+this.direction);
        }
    }
    public String getPotition(){
        return  "(" + this.postX + "," + this.postY+ ")";
    }

    public String print() {
        return "Robot{" +
                "postX=" + postX +
                ", postY=" + postY +
                ", commands=" + Arrays.toString(commands) +
                ", direction=" + direction +
                '}';
    }
}
