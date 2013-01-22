package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import service.JobsService;


import com.google.gson.Gson;

import entity.Jobs;

@Controller
public class JobController {
	
	@Autowired
	private JobsService jobsService ;
	
	
	@RequestMapping(value="/JobReader", method=RequestMethod.GET)
	public @ResponseBody
	String getJobs(){
		
		List<Jobs> jobsData = new ArrayList<Jobs>();
		jobsData = jobsService.GetMessages();
		Gson gson = new Gson();
		String output = gson.toJson(jobsData);
		output= "{\"Messages\":"+output+"}";
		System.out.println("json data"+output);
		return output;
	}

	/**
	 * @param jobsService the jobsService to set
	 */
	public void setJobsService(JobsService jobsService) {
		this.jobsService = jobsService;
	}

}
