package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.EmpMapper;
import mapper.ProblemMapper;

import org.springframework.stereotype.Service;

import entity.Problem;

import service.EmpService;
import service.ProblemService;

@Service("problemServiceImpl")
public class ProblemServiceImpl implements ProblemService {
	@Resource(name = "problemMapper")
	ProblemMapper problemMapper = null;
	
	public ProblemMapper getProblemMapper() {
		return problemMapper;
	}

	public void setProblemMapper(ProblemMapper problemMapper) {
		this.problemMapper = problemMapper;
	}

	public List findAllProblem() {
		
		return problemMapper.findAllProblem();
	}

	public List findByPageProblem(int first, int last) {
		return problemMapper.findByPageProblem(first, last);
	}

	public int findCount() {
		return problemMapper.findCount();
	}

	public void deleteProblem(String problemTitle) {
		problemMapper.deleteProblem(problemTitle);
		
	}
	public int saveProblem(Problem p) {
		return problemMapper.saveProblem(p);
	}

	public Problem findByTitleProblem(String problemTitle) {
		return problemMapper.findByTitleProblem(problemTitle);
	}

	public void updateProblem(Problem p) {
		problemMapper.updateProblem(p);
		
	}
}
