/*
 * ComputerEngineer.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

/**
 * 装机工程师
 * @ClassName: ComputerEngineer 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class ComputerEngineer {
	
	//组装机需要的cpu
	private Cpu cpu = null;
	
	//组装机需要的主板
	private Mainboard mainboard = null;
	
	public void makeComputer(AbstractFactory abstractFactory){
		//组装步骤
		//1.准备配件
		prepareHardwares(abstractFactory);
		//2.组装机器
		//3.测试机器
		//4.交付客户
	}

	private void prepareHardwares(AbstractFactory abstractFactory) {
		//准备cpu和mainboard的具体实现
		this.cpu = abstractFactory.createCpu();
		this.mainboard = abstractFactory.createMainboard();
		
		//测试
		this.cpu.calculate();
		this.mainboard.installCpu();
	}
}
