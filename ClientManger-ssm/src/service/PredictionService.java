package service;

import java.util.List;

import entity.Prediction;

public interface PredictionService {
	public List findAllPrediction(int first,int last);
	public int findcountPredic();
	public int insertPrediction(Prediction prediction);
	public Prediction findByTitlePredic(String predictionTitle);
}
