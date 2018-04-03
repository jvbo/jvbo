/*
 * StringList.java 2018年3月14日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class StringList implements Serializable {
    /*private int size = 0;
    private Entry head = null;
    private static class Entry implements Serializable{
        String data;
        Entry next;
        Entry previous;
    }*/
    
    
    
    private transient int size = 0;
    private transient Entry head = null;
    
    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }
    
    public final void add(String s){
        
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        oos.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            oos.writeObject(e.data);
        }
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
        ois.defaultReadObject();
        int numElements = ois.readInt();
        for (int i = 0; i < numElements; i++) {
            add((String)ois.readObject());
        }
    }
}
