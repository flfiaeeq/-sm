package mapper;

import java.util.List;

import entity.Prediction;



public interface PredictionMapper {
	public List findAllPrediction(int first,int last);
	public int findcountPredic();
	public int insertPrediction(Prediction prediction);
	public List findByTitlePredic(String predictionTitle);
	
}
