package com.youfan.service.pay;

import org.springframework.stereotype.Service;

@Service
public class YinghangkapayImpl implements Yinghangkapay{

public int paywithorder(String tradeserialnumber, int payamount) {
		System.out.println("银联支付成功");
		return 1;
	}

public int refundwithorder(String tradeserialnumber, int payamount) {
	System.out.println("银联退款成功");
	return 1;
}

}
