package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.DeptMapper;

import org.springframework.stereotype.Service;

import entity.Dept;

import service.DeptService;

@Service("deptServiceImpl")
public class DeptServiceImpl implements DeptService {
	@Resource(name = "deptMapper")
	private DeptMapper deptMapper = null;

	public DeptMapper getDeptMapper() {
		return deptMapper;
	}

	public void setDeptMapper(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	public List findAllDeptEmpt(String deptname) {
		// TODO Auto-generated method stub
		return deptMapper.findAllDeptEmpt(deptname);
	}

	public List findAllDept() {
		// TODO Auto-generated method stub
		return deptMapper.findAllDept();
	}

	
	public int delete(String deptId) {
		// TODO Auto-generated method stub
		return deptMapper.delete(deptId);
	}


	public Dept findDept(String deptId) {
		// TODO Auto-generated method stub
		return deptMapper.findDept(deptId);
	}

	public List findDeptFather() {
		// TODO Auto-generated method stub
		return deptMapper.findDeptFather();
	}

	public int save(Dept dept) {
		// TODO Auto-generated method stub
		return deptMapper.save(dept);
	}

	public int update(Dept dept) {
		// TODO Auto-generated method stub
		return deptMapper.update(dept);
	}

	public List findDeptShortName() {
		// TODO Auto-generated method stub
		return deptMapper.findDeptShortName();
	}

	
}
