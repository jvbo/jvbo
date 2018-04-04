/*
 * VisualComponent.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 将线程安全性委托给多个状态变量
 * @ClassName: VisualComponent 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class VisualComponent {
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();
    
    public void addKeyListener(KeyListener listener){
        keyListeners.add(listener);
    }
    
    public void addMouseListener(MouseListener listener){
        mouseListeners.add(listener);
    }
    
    public void removeKeyListener(KeyListener listener){
        keyListeners.remove(listener);
    }
    
    public void removeMouseListener(MouseListener listener){
        mouseListeners.remove(listener);
    }
}
