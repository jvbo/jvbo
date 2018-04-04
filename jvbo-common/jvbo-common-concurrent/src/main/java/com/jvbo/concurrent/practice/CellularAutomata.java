/*
 * CellularAutomata.java 2018年4月5日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 通过 #CyclicBarrier 协调细胞自动衍生系统中的计算
 * @ClassName: CellularAutomata 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月5日
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;
    
    public CellularAutomata(Board board){
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable(){

            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
            
        });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }
    
    private class Worker implements Runnable{
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while(!board.hasConverged()){
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }

        private Object computeValue(int x, int y) {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
    public void start(){
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }
}

class Board{
    public void commitNewValues() {
        // TODO Auto-generated method stub
        
    }

    public void waitForConvergence() {
        // TODO Auto-generated method stub
        
    }

    public void setNewValue(int x, int y, Object computeValue) {
        // TODO Auto-generated method stub
        
    }

    public int getMaxX() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getMaxY() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean hasConverged() {
        // TODO Auto-generated method stub
        return false;
    }

    public Board getSubBoard(int count, int i) {
        // TODO Auto-generated method stub
        return null;
    }
}
