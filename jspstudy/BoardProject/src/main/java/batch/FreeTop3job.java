package batch;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeTop3job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// Job : 스케쥴러가 처리하는 작업
		
		List<Free> top3 = FreeDAO.getInstance().selectFreesTop3();
		
		for(Free f : top3) {
			System.out.println(f.getFreeNo() + "\n" + f.getWriter() + "\n" + f.getTitle() + "\n" + f.getIp() + "\n" + f.getHit() + "\n" + f.getContent());
		}
	}

}
