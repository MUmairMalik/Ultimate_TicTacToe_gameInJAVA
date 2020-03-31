/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;

/**
 *
 * @author Hamza
 */
public class Game {
    private int[][] grid; //4x4 grid where 0 represents 'O' and 1 represents 'X'

    public Game() {
        grid = new int[4][4];
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                grid[i][j] = -1;
            }
        }
    }
    
    public void setGrid(int row, int col, int value) {
        if(grid[row][col] == -1) {
            if(value == 0 || value == 1)
                grid[row][col] = value;
            else
                System.out.println("Value can only be zero or one");
        }
        else
            System.out.println("It already contains other player's symbol");
    }
    
    public boolean checkWin(int checkFor) { //checkFor means check for whom? ... like for ones or zeroes
        if(checkFor == 0 || checkFor == 1) {
            
            //checking horizontally
            boolean check = false;
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    if(grid[i][j] == checkFor)
                        check = true;
                    else {
                        check = false;
                        break;
                    }
                }
                if(check)
                    return true;
            }
            
            //checking vertically
            check = false;
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    if(grid[j][i] == checkFor)
                        check = true;
                    else {
                        check = false;
                        break;
                    }
                }
                if(check)
                    return true;
            }
            
            //checking diagonal 1
            check = false;
            for(int i=0; i<4; i++) {
                if(grid[i][i] == checkFor)
                    check = true;
                else {
                    check = false;
                    break;
                }
            }
            if(check)
                return true;
            
            //checking diagonal 2
            check = false;
            int j=3;
            for(int i=0; i<4; i++) {
                if(grid[i][j] == checkFor)
                    check = true;
                else {
                    check = false;
                    break;
                }
                j--;
            }
            if(check)
                return true;
            
            return false; //no match found
        }
        else {
            System.out.println("CheckFor must be 0 or 1");
            return false;
        }
    }
    
    private Point findThree(int checkFor) {
        
        Point p = null;
        
        if(checkFor == 0 || checkFor == 1) {
            
            //checking horizontally
            int count;
            for(int i=0; i<4; i++) {
                count = 0;
                for(int j=0; j<4; j++) {
                    if(grid[i][j] == checkFor)
                        count++;
                    else
                        p = new Point(i, j);
                }
                if(count == 3 && p!=null && grid[p.getRow()][p.getCol()] == -1)
                    return p;
            }
            
            //checking vertically
            for(int i=0; i<4; i++) {
                count = 0;
                for(int j=0; j<4; j++) {
                    if(grid[j][i] == checkFor)
                        count++;
                    else
                        p = new Point(j, i);
                }
                if(count == 3 && p!=null && grid[p.getRow()][p.getCol()] == -1)
                    return p;
            }
            
            //checking diagonal 1
            count=0;
            for(int i=0; i<4; i++) {
                if(grid[i][i] == checkFor)
                    count++;
                else
                    p = new Point(i, i);
            }
            if(count == 3 && p!=null && grid[p.getRow()][p.getCol()] == -1)
                return p;
            
            //checking diagonal 2
            count = 0;
            int j=3;
            for(int i=0; i<4; i++) {
                if(grid[i][j] == checkFor)
                    count++;
                else
                    p = new Point(i, j);
                j--;
            }
            if(count == 3 && p!=null && grid[p.getRow()][p.getCol()] == -1)
                return p;
            
            return null; //no match found having 3 same symbols
        }
        else
            return null;
    }
    
    private Point findTwo(int checkFor) {
        
        Point p[];
        p = new Point[4];
        for(int i=0; i<4; i++)
            p[i] = new Point();
        int index;
        
        if(checkFor == 0 || checkFor == 1) {
            
            //checking horizontally
            int count;
            for(int i=0; i<4; i++) {
                count = 0;
                index = 0;
                for(int j=0; j<4; j++) {
                    if(grid[i][j] == checkFor)
                        count++;
                    else {
                        p[index].setRow(i);
                        p[index].setCol(j);
                        index++;
                    }
                }
                if(count == 2 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(2);
                    return p[ran];
                }
            }
            
            //checking vertically
            for(int i=0; i<4; i++) {
                count = 0;
                index = 0;
                for(int j=0; j<4; j++) {
                    if(grid[j][i] == checkFor)
                        count++;
                    else {
                        p[index].setRow(j);
                        p[index].setCol(i);
                        index++;
                    }
                }
                if(count == 2 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(2);
                    return p[ran];
                }
            }
            
            //checking diagonal 1
            count=0;
            index = 0;
            for(int i=0; i<4; i++) {
                if(grid[i][i] == checkFor)
                    count++;
                else {
                    p[index].setRow(i);
                    p[index].setCol(i);
                    index++;
                }
            }
            if(count == 2 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(2);
                    return p[ran];
                }
            
            //checking diagonal 2
            count = 0;
            index = 0;
            int j=3;
            for(int i=0; i<4; i++) {
                if(grid[i][j] == checkFor)
                    count++;
                else {
                    p[index].setRow(i);
                    p[index].setCol(j);
                    index++;
                }
                j--;
            }
            if(count == 2 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(2);
                    return p[ran];
                }
            
            return null; //no match found having 2 same symbols
        }
        else
            return null;
    }
    
    private Point findOne(int checkFor) {
        
        Point p[];
        p = new Point[4];
        for(int i=0; i<4; i++)
            p[i] = new Point();
        int index;
        
        if(checkFor == 0 || checkFor == 1) {
            
            //checking horizontally
            int count;
            for(int i=0; i<4; i++) {
                count = 0;
                index = 0;
                for(int j=0; j<4; j++) {
                    if(grid[i][j] == checkFor)
                        count++;
                    else {
                        p[index].setRow(i);
                        p[index].setCol(j);
                        index++;
                    }
                }
                if(count == 1 && grid[p[0].getRow()][p[0].getCol()] == -1 && grid[p[1].getRow()][p[1].getCol()] == -1 && grid[p[2].getRow()][p[2].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(3);
                    return p[ran];
                }
            }
            
            //checking vertically
            for(int i=0; i<4; i++) {
                count = 0;
                index = 0;
                for(int j=0; j<4; j++) {
                    if(grid[j][i] == checkFor)
                        count++;
                    else {
                        p[index].setRow(j);
                        p[index].setCol(i);
                        index++;
                    }
                }
                if(count == 1 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1 && grid[p[2].getRow()][p[2].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(3);
                    return p[ran];
                }
            }
            
            //checking diagonal 1
            count=0;
            index = 0;
            for(int i=0; i<4; i++) {
                if(grid[i][i] == checkFor)
                    count++;
                else {
                    p[index].setRow(i);
                    p[index].setCol(i);
                    index++;
                }
            }
            if(count == 1 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1 && grid[p[2].getRow()][p[2].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(3);
                    return p[ran];
                }
            
            //checking diagonal 2
            count = 0;
            index = 0;
            int j=3;
            for(int i=0; i<4; i++) {
                if(grid[i][j] == checkFor)
                    count++;
                else {
                    p[index].setRow(i);
                    p[index].setCol(j);
                    index++;
                }
                j--;
            }
            if(count == 1 && grid[p[0].getRow()][p[0].getCol()] == -1  && grid[p[1].getRow()][p[1].getCol()] == -1 && grid[p[2].getRow()][p[2].getCol()] == -1) {
                    Random r = new Random();
                    int ran = r.nextInt(3);
                    return p[ran];
                }
            
            return null; //no match found having 1 its own symbol
        }
        else
            return null;
        
    }
    
    public Point playComputer(int comSym) { //value is basically computer's symbol
        if(comSym == 0 || comSym == 1) {
            int playerSym;
            if(comSym == 0)
                playerSym = 1;
            else
                playerSym = 0;
            
            
            Point p = findThree(comSym);
            if(p != null) { //if computer has 3 same symbols
                grid[p.getRow()][p.getCol()] = comSym;
                return p;
            }
            
            p = findThree(playerSym);
            if(p != null) { //if player has 3 same symbols
                grid[p.getRow()][p.getCol()] = comSym;
                return p;
            }
            
            p = findTwo(comSym);
            if(p != null) { //if computer has 2 same symbols
                grid[p.getRow()][p.getCol()] = comSym;
                return p;
            }
            
            p = findTwo(playerSym);
            if(p != null) { //if player has 2 same symbols
                grid[p.getRow()][p.getCol()] = comSym;
                return p;
            }
            
            p = findOne(comSym);
            if(p != null) { //if computer has 1 symbol with whole remaining blocks empty
                grid[p.getRow()][p.getCol()] = comSym;
                return p;
            }
            
            //decides to place randomly
//            while(true) {
//                Random rand = new Random();
//                int r = rand.nextInt(4);
//                int c = rand.nextInt(4);
//                if(grid[r][c] == -1)
//                    return new Point(r, c);
//            }

            int count=0;
            Point[] free = new Point[16];
            for(int i=0; i<16; i++)
                free[i] = new Point();
            
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    if(grid[i][j] == -1) {
                        free[count].setRow(i);
                        free[count].setCol(j);
                        count++;
                    }
                }
            }

            Random rand = new Random();
            int r = rand.nextInt(count);
            this.setGrid(free[r].getRow(), free[r].getCol(), comSym);
            return free[r];
        }
        else {
            System.out.println("comSym must be 0 or 1");
            return null;
        }
    }
    
    public boolean checkDraw() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(grid[i][j] == -1)
                    return false;
            }
        }
        return true;
    }
}
