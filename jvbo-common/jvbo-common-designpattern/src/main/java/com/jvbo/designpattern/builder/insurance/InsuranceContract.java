/*
 * InsuranceContract.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.insurance;

/**
 * 保险合同类
 * @ClassName: InsuranceContract 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class InsuranceContract {
	
	private String contractId;//保险合同编号
	
	/**
	 * 被保险人员名称，同一份保险要么和人员签订，要么和公司签订
	 * 即，“被保险人员”和“被保险公司”这两个属性，不可能同时有值
	 */
	private String personName;
	
	private String companyName;//被保险公司的名称
	
	private Long beginDate;//保险开始生效日期
	
	private Long endDate;//保险失效日期，一定大于开始生效日期
	
	private String otherData;//其他数据
	
	//私有构造方法
	private InsuranceContract(ConcreteBuilder builder){
		this.contractId = builder.contractId;
        this.personName = builder.personName;
        this.companyName = builder.companyName;
        this.beginDate = builder.beginDate;
        this.endDate = builder.endDate;
        this.otherData = builder.otherData;
	}
	
	//保险合同的一些操作
	public void someOperation(){
		System.out.println("当前正在操作的保险合同编号是：" + this.contractId);
	}
	
	public static class ConcreteBuilder{
		private String contractId;//保险合同编号
		
		private String personName;
		
		private String companyName;//被保险公司的名称
		
		private Long beginDate;//保险开始生效日期
		
		private Long endDate;//保险失效日期，一定大于开始生效日期
		
		private String otherData;//其他数据
		
		public ConcreteBuilder(String contractId, long beginDate, long endDate){
			this.contractId = contractId;
			this.beginDate = beginDate;
			this.endDate = endDate;
		}
		
		//人员名称
		public ConcreteBuilder setPersonName(String personName){
			this.personName = personName;
			return this;
		}
		
		//公司名称
		public ConcreteBuilder setCompanyName(String companyName){
			this.companyName = companyName;
			return this;
		}
		
		//其他数据
		public ConcreteBuilder setOtherData(String otherData){
			this.otherData = otherData;
			return this;
		}
		
		/**
		 * 构建真正的对象并返回
		 * @Description: TODO
		 * @param @return   
		 * @return InsuranceContract  
		 * @throws
		 * @author jvbo
		 * @date 2017年11月1日
		 */
		public InsuranceContract build(){
			//业务逻辑，如参数校验
			return new InsuranceContract(this);
		}
	}
	
}
