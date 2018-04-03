/*
 * ApacheCommonLang3Test.java 2017年6月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.apachecommon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class ApacheCommonLang3Test {

	public static void main(String[] args) throws ParseException {
		/*NumberUtils.isDigits("1");

        StringUtils.isNoneBlank("");

        DateUtils.isSameDay(new Date(), new Date());


        ArrayUtils.isNotEmpty(new String[]{"a", "b", "c"});

        List<String> list = Lists.newArrayList();
        CollectionUtils.isNotEmpty(list);

        System.out.println(DateFormatUtils.format(
                DateUtils.ceiling(new Date(), 1),
                "yyyy-MM-dd HH:mm:ss"
                ));

        String pattern = "yyyy-MM-dd HH:mm:ss";
        long durationMillis = (10+20*60+13*3600+4*24*3600) * 1000;
        String formatDate = DurationFormatUtils.formatDuration(durationMillis, pattern);
        //System.out.println(formatDate);

        int i = -5;
        if (i % 2 == 0) {
            System.out.println("偶数:"+i);
        } else {
            System.out.println("奇数:"+i);
        }*/

        /*List<String> strList = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            strList.add(i+"");
        }

        for (int j = 0; j < strList.size(); j++) {
            System.out.println(strList.get(j));
        }*/
        
		//dateConvert();
		/*String webRoot = System.getProperty("user.dir") 
				+ File.separator + "webroot";
		System.out.println(webRoot);*/
		
		//System.out.println(System.currentTimeMillis());//1500431090881
		
		//strStartWith();
		
		//forOuter();
		//System.out.println(System.currentTimeMillis());
       // System.out.println(DateFormatUtils.format(Long.valueOf("1502091605847"), "yyyy-MM-dd HH:mm:ss"));
        
        //System.out.println(DateUtils.addYears(new Date(), 100).getTime());
        //System.out.println(getTextFromTHML(""));
        //disjunction();
        
        //aliGmtDate();
        //addJsonArr();
		
		//testRemoveAddAndNewPerformance();
		
		//handlerStr();
		
		//List2StrShow();
		
		//System.out.println(System.currentTimeMillis());
		//System.out.println(Clock.systemUTC().millis());
		/*String skuList = "[{\"price\":222,\"amountOnSale\":333,\"retailPrice\":\"\",\"cargoNumber\":\"\",\"specAttributes\":{\"450\":\"XS\",\"3216\":\"黄色\"},\"skuImageUrl\":\"\"},{\"price\":222,\"amountOnSale\":333,\"retailPrice\":\"\",\"cargoNumber\":\"\",\"specAttributes\":{\"3216\":\"黄色\"},\"skuImageUrl\":\"\"},{\"price\":222,\"amountOnSale\":333,\"retailPrice\":\"\",\"cargoNumber\":\"\",\"specAttributes\":{\"450\":\"XS\",\"3216\":\"白色\"},\"skuImageUrl\":\"\"},{\"price\":222,\"amountOnSale\":333,\"retailPrice\":\"\",\"cargoNumber\":\"\",\"specAttributes\":{\"3216\":\"白色\"},\"skuImageUrl\":\"\"}]";
		String json = JSON.parse(skuList).toString();
		System.out.println(json);
		JSONArray jsonArr = JSON.parseArray(json);
		for (int i = 0; i < jsonArr.size(); i++) {
			System.out.println(jsonArr.get(i));
		}*/
		
		/*JSONObject json = null;
		System.out.println(json);
		if(json == null){
			json = new JSONObject();
		}
		System.out.println(json);*/
	    
	    System.out.println(NumberUtils.isDigits("4a"));
	}
	
	public static void List2StrShow(){
		List<String> strList = Lists.newArrayList();
		for (int i = 0; i < 5; i++) {
			strList.add(String.valueOf(i));
		}
		String jsonStr = ArrayUtils.toString(strList);
		System.out.println(jsonStr);
		String inStrStart = StringUtils.removeFirst(jsonStr, "[");
		String inStrEnd = StringUtils.removeAll(inStrStart, "]");
		System.out.println(inStrEnd);
	}
	
	public static void handlerStr(){
		String str = ";20509:28316;1627207:28341;";
		str = StringUtils.removeFirst(str, ";");
		str = StringUtils.removeEnd(str, ";");
		System.out.println(str);
	}
	
	// TODO remove(index)之后add(index,Object)和new Object比较
	public static void testRemoveAddAndNewPerformance(){
		List<Person> personList = Lists.newArrayList();
		Person person = null;
		for (int i = 0; i < 10; i++) {
			person = new Person();
			person.setId(String.valueOf(i));
			person.setName(String.valueOf(i));
			person.setAge(i);
			personList.add(person);
		}
		removeList(personList);
		newList(personList);
	}
	
	public static void removeList(List<Person> personList){
		List<Person> personRemoveList = Lists.newArrayList();
		personRemoveList.addAll(personList);
		long removeStart = System.nanoTime();
		for (int i = 0; i < personRemoveList.size(); i++) {
			Person handlePerson = personRemoveList.get(i);
			if(i == i){
				personRemoveList.remove(i);
				personRemoveList.add(i, handlePerson);
			}
		}
		long removeEnd = System.nanoTime();
		System.out.println("remove耗时:" + (removeEnd - removeStart));
	}
	
	public static void newList(List<Person> personList){
		List<Person> personNewList = Lists.newArrayList();
		Person personNew = null;
		long newStart = System.nanoTime();
		for (int i = 0; i < personList.size(); i++) {
			Person handlePerson = personList.get(i);
			if(i == i){
				personNewList.add(handlePerson);
			}
		}
		long newEnd = System.nanoTime();
		System.out.println("new耗时:" + (newEnd - newStart));
	}
	
	public static void addJsonArr(){
		JSONArray jsonArr = new JSONArray();
		jsonArr.add(0, 0);
		jsonArr.add(1, 1);
		for (int i = 0; i < jsonArr.size(); i++) {
			System.out.println(jsonArr.get(i));
		}
		jsonArr.remove(0);
		jsonArr.add(0, 9);
		for (int i = 0; i < jsonArr.size(); i++) {
			System.out.println(jsonArr.get(i));
		}
	}
	
	public static void reentrantLockCondition(){
		ReentrantLock rl = new ReentrantLock();
		Condition ct = rl.newCondition();
		rl.lock();
		rl.unlock();
	}
	
	public static void aliGmtDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");
		try {
			System.out.println(sdf.parse("20170905130514461+0800").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * for-outer使用
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月28日
	 */
	public static void forOuter(){
		/*outer:
			for (int i = 0; i < 5; i++) {
				if(i==3){
					continue outer;
				}
				System.out.println(1);
			}*/
		outer:
			while(true){
				System.out.println(1);
				continue outer;
				//System.out.println(2);
			}
	}
	
	/**
	 * 日期转换
	 * @Description: TODO
	 * @param @throws ParseException   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月28日
	 */
	public static void dateConvert() throws ParseException{
		String date = "2018-06-29 00:00:00";//1498551554000
        long afterTime = DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss").getTime();
        System.out.println("afterTime:" + afterTime);
        System.out.println(DateFormatUtils.format(Long.valueOf("1500815927128"), "yyyy-MM-dd HH:mm:ss"));
		
		/*String date = "2017-6" + "-01 00:00:00";
		int year = NumberUtils.toInt(DateFormatUtils.format(DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss"), "yyyy"));
		int month = NumberUtils.toInt(DateFormatUtils.format(DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss"), "MM"));
		System.out.println(year);
		System.out.println(month);
        System.out.println(DateUtils.addYears(DateUtils.parseDate(DateFormatUtils.format(Long.valueOf("1499331449736"), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"), 1).getTime());*/
	}
	
	/**
	 * 字符串以 T 开头
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月28日
	 */
	public static void strStartWith(){
		String sql = "select * from user";
		if(StringUtils.startsWith(sql, "select"))
			System.out.println(true);
		else
			System.out.println(false);
	}
	
	/**
	 * 过滤字符串中html标签
	 * @Description: TODO
	 * @param @param htmlStr
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月28日
	 */
	public static String getTextFromTHML(String htmlStr) {
		htmlStr = "<br/>军绿连衣裙穿出休闲味道时尚出街 气质之选个性帅气 青春活力这款军绿色连衣裙个性又帅气，让你穿出休闲的味道，细节设计也并不单调，典型圆领的麻花编织带设计，增添时尚甜美气息，上身的精致褶皱，让整体造型更立体大方，又不失青春活力，半两件的设计，看着更挺括飘逸，优雅灵动，这款连衣裙你还能穿出女人味之外的感觉哟，显瘦又有范。显瘦H型拉长身形 更显高挑显瘦H版型，半两件的设计，看着更挺括飘逸，优雅灵动。精致立体褶皱腰间部分的精致缝褶，个性时尚，让整体造型看上去更加立体大方。优雅编织带圆领上精致的编织带设计，优雅时尚，美观精致，增添整体的档次感。飘逸雪纺细腻柔滑 清爽透气轻薄的雪纺面料，透气清爽，手感细腻舒适，优雅飘逸，浪漫灵动，易打理。米粉：裙子是两件套吗？一米：不是，设计个性美观。米粉：裙子是否有里布？一米：没有里布，穿着亲肤舒适，贴心不透。飘逸雪纺轻薄的雪纺手感顺滑细腻，穿着舒适透气，飘逸又灵动。精致编织带典型圆领，清爽得体，优雅编织带，美观时尚。简约肩带吊带细小精巧，个性灵活，造成两件套的视觉感受。清爽衣袖无袖设计，清爽舒适，展现纤细手臂。精致缝褶腰间精致缝制，个性时尚，造型更立体美观。精致做工剪裁恰到好处，车线工整细密，追求非凡做工。";
		Document doc = Jsoup.parse(htmlStr);
        String text = doc.text();
        // remove extra white space
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while(builder.length()>index){
            char tmp = builder.charAt(index);
            if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
                builder.setCharAt(index, ' ');
            }
            index++;
        }
        text = builder.toString().replaceAll(" +", " ").trim();
        return text;
    }
	
	public static void useArrayBlockingQueue(){
		ArrayBlockingQueue abq = new ArrayBlockingQueue(2);
	}
	
	/**
	 * 交集的补集
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年9月1日
	 */
	public static void disjunction(){
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		List<String> b = new ArrayList<String>();
		b.add("4");
		b.add("5");
		b.add("6");
		b.add("7");
		b.add("8");
		b.add("9");
		List<String> disjunctionMenuIdList = (List<String>) CollectionUtils.disjunction(a,b);
		for (String string : disjunctionMenuIdList) {
			System.out.println(string);
		}
	}

}
