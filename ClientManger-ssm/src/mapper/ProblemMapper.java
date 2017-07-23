package mapper;

import java.util.List;

import entity.Problem;
import entity.Server;

public interface ProblemMapper {
	public List findAllProblem();
	public List findByPageProblem(int first,int last);
	public int findCount();
	
	public int saveProblem(Problem p);
	public void deleteProblem(String problemTitle);
	public void updateProblem(Problem p);
	public void serverSubmit(Problem p);
	public Problem findByTitleProblem(String problemTitle);
}
