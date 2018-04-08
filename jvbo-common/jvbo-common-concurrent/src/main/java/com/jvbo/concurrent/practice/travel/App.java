/*
 * App.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.travel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 在预订时间内请求旅游报价
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月8日
 */
public class App {
    private static final ExecutorService exec = Executors.newFixedThreadPool(10);
    
    public List<TravelQuote> getRankedTravelQuotes(TravelInfo travelInfo, Set<TravelCompany> companies,
            Comparator<TravelQuote> ranking, long time, TimeUnit unit) throws InterruptedException{
        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companies) {
            tasks.add(new QuoteTask(company, travelInfo));
        }
        
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, unit);
        
        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> taskIter = tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e){
                quotes.add(task.getTimeoutQuote(e));
            }
        }
        Collections.sort(quotes, ranking);
        return quotes;
    }
    
    public class QuoteTask implements Callable<TravelQuote> {
        private final TravelCompany company;
        private final TravelInfo travelInfo;
        
        public QuoteTask(TravelCompany company, TravelInfo travelInfo){
            this.company = company;
            this.travelInfo = travelInfo;
        }

        public TravelQuote getTimeoutQuote(CancellationException e) {
            // TODO Auto-generated method stub
            return null;
        }

        public TravelQuote getFailureQuote(Throwable cause) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public TravelQuote call() throws Exception {
            return company.solicitQuote(travelInfo);
        }

    }
}
