package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.PredictionMapper;

import org.springframework.stereotype.Service;

import entity.Prediction;

import service.PredictionService;

@Service("predictionServiceImpl")
public class PredictionServiceImpl implements PredictionService {
	@Resource(name = "predictionMapper")
	private PredictionMapper predictionMapper = null;

	public PredictionMapper getPredictionMapper() {
		return predictionMapper;
	}

	public void setPredictionMapper(PredictionMapper predictionMapper) {
		this.predictionMapper = predictionMapper;
	}

	public List findAllPrediction(int first,int last) {
		// TODO Auto-generated method stub
		return predictionMapper.findAllPrediction(first,last);
	}

	public int findcountPredic() {
		// TODO Auto-generated method stub
		return predictionMapper.findcountPredic();
	}

	public int insertPrediction(Prediction prediction) {
		// TODO Auto-generated method stub
		return predictionMapper.insertPrediction(prediction);
	}

	public Prediction findByTitlePredic(String predictionTitle) {
		// TODO Auto-generated method stub
		List findByTitlePredic = predictionMapper.findByTitlePredic(predictionTitle);
		if(findByTitlePredic.size()!=0){
		return (Prediction) findByTitlePredic.get(0);
		}
		return null;
	}

}
