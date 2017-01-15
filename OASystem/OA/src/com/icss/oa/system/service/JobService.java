package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Job;

/**
 * 职务业务
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * 增加职务
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}
	
	/**
	 * 修改职务
	 */
	public void updateJob(Job job) throws SQLException {
		dao.update(job);
	}
	
	/**
	 * 删除职务
	 */
	public void deleteJob(int jobId) throws SQLException {
		dao.delete(jobId);
	}
	
	/**
	 * 查询单独的职务
	 */
	public Job queryJobById(int jobId) throws SQLException {
		
		return dao.queryById(jobId);
	}
	
	/**
	 * 查询所有职务
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryAllJob() throws SQLException {
		
		return dao.queryAll();
	}

}