package com.jvbo.common.study.javaee.netty.protocol.http.pojo;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class ObjectFactory {
	public static Order create(long orderID) {
		Order order = new Order();
		order.setOrderNumber(orderID);
		order.setTotal(9999.999f);
		Address address = new Address();
		address.setCity("杭州");
		address.setCountry("中国");
		address.setPostCode("111111");
		address.setState("浙江省");
		address.setStreet1("文一西路");
		order.setBillTo(address);
		Customer customer = new Customer();
		customer.setCustomerNumber(orderID);
		customer.setFirstName("张");
		customer.setLastName("三");
		order.setCustomer(customer);
		order.setShipping(Shipping.INTERNATIONAL_MAIL);
		order.setShipTo(address);
		return order;
	}
}
