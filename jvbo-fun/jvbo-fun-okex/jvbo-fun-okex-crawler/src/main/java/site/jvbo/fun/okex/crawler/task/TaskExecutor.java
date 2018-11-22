package site.jvbo.fun.okex.crawler.task;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
@Component
public class TaskExecutor {

	private List<Task> tasks = null;

	@Autowired
	private Task webSocketTask;

	public void addTask(){
		if(null == tasks){
			tasks = new ArrayList<>();
		}
		this.tasks.add(webSocketTask);
	}

	public void execute(){
		if(CollectionUtils.isNotEmpty(this.tasks)){
			ExecutorService pool = Executors.newFixedThreadPool(this.tasks.size());
			for (Task task: tasks) {
				pool.execute(task);
			}
		}

	}

	public void join() throws InterruptedException {
		for (Task task: tasks) {
			task.executeThread().join();
		}
	}
    
}
