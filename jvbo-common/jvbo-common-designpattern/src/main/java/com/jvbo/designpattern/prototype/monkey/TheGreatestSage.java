/*
 * TheGreatestSage.java 2017年11月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.monkey;

/**
 * 原型模式-深度克隆与浅度克隆(客户角色)
 * @ClassName: TheGreatestSage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月7日
 */
public class TheGreatestSage {
	
	private Monkey monkey = new Monkey();
	
	public void change(){
		//克隆大圣本尊
		Monkey copyMonkey = (Monkey)monkey.clone();
		System.out.println("大圣本尊生日:" + monkey.getBirthDate());
		System.out.println("克隆大圣生日:" + copyMonkey.getBirthDate());
		System.out.println("大圣本尊和克隆大声是否是同一对象:" + (monkey == copyMonkey));
		System.out.println("大圣本尊持有的金箍棒 和 克隆大圣持有的金箍棒是否是统一个对象:" + 
		(monkey.getStaff() == copyMonkey.getStaff()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheGreatestSage sage = new TheGreatestSage();
		sage.change();
	}

}

/**
 * 原型模式优点:原型模式允许在运行时动态改变具体的实现类型,原型模式可以在运行期间,
 * 由客户来注册符合原型接口的实现类型,也可以动态的改变具体的实现类型,看起来接口没有任何变化,
 * 但其实运行的已经是另外一个类实例了,因为克隆一个原型就类似于实例化一个类;
 * 
 * 原型模式的缺点:最主要的缺点是没一个类都	必须配备一个克隆方法,
 * 配备克隆方法需要对类的功能进行通盘考虑,
 * 这对于全新的类不是很难,而对于已经有的类不一定很容易,特别是当一个类引用不支持序列化的间接对象,
 * 或者引用含有循环结构的时候;
 */
