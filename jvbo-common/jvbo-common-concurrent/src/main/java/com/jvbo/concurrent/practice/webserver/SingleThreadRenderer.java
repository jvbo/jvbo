/*
 * SingleThreadRenderer.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.webserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 串行的渲染页面元素
 * @ClassName: SingleThreadRenderer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class SingleThreadRenderer {
    void renderPage(CharSequence source){
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageData imageInfo : imageData) {
            imageData.add(imageInfo.downloadImage());
        }
        for (ImageData data : imageData) {
            renderImage(data);
        }
    }

    void renderImage(ImageData data) {
        // TODO Auto-generated method stub
        
    }

    void renderText(CharSequence source) {
        // TODO Auto-generated method stub

    }
}
