package site.jvbo.fun.okex.crawler.task;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public interface Task extends Runnable {

	void doTask();

	Thread executeThread();

}
