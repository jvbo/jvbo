/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.macroaudioplay;

public class Client {
	public static void main(String[]args){
		//创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        
        MacroCommand marco = new MacroAudioCommand();
        
        marco.add(playCommand);
        marco.add(rewindCommand);
        marco.add(stopCommand);
        marco.execute();
    }
}

/**
 * 命令模式的优点:
 * 1.更松散的耦合:使得发起命令的对象-客户端,和具体实现命令的对象-接受者对象完全解耦,
 * 即发起命令的对象完全不知道具体实现对象是谁,也不知道如何实现;
 * 
 * 2.更动态的控制:把请求封装起来,可以动态的对它进行参数化,队列化和日志化等操作,从而使系统更灵活;
 * 
 * 3.很自然的复合命令:命令模式中的命令对象能够很容易的组合成符合命令,即宏命令,从而使系统操作更简单,功能更强大;
 * 
 * 4.更好的扩展性:由于发起命令的对象和具体的实现完全解耦,因此扩展新的命令就很容易,
 * 只需要实现新的命令对象,然后在装配的时候,把具体的实现对象设置到命令对象中,然后就可以使用这个命令对象,
 * 已有的实现完全不用变化;
 */
