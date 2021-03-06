package net.igulu.bigsix.predictionservice.service;

import net.igulu.bigsix.predictionservice.model.Prediction;
import net.igulu.bigsix.predictionservice.model.PredictionType;
import net.igulu.bigsix.predictionservice.repository.PredictionRepository;
import net.igulu.bigsix.predictionservice.repository.PredictionTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Resource
    PredictionTypeRepository predictionTypeRepository;

    @Resource
    PredictionRepository predictionRepository;

    @Override
    public Prediction findByHostTeamIdAndGuestTeamIdAndPredictionTypeId(Integer hostTeamId, Integer guestTeamId, Integer predictionTypeId) {
        Prediction prediction = predictionRepository.findByHostTeamIdAndGuestTeamIdAndPredictionTypeId(hostTeamId, guestTeamId, predictionTypeId);
        if (prediction != null) {
            System.out.println(prediction);
            return prediction;
        } else {
            Prediction newPrediction = new Prediction(hostTeamId, guestTeamId, predictionTypeId);
            System.out.println(newPrediction);
            return predictionRepository.save(newPrediction);
        }
    }

    @Override
    public ArrayList<PredictionType> findAllPredictionTypes() {
        return predictionTypeRepository.findAll();
    }

    @Override
    public PredictionType findPredictionTypeById(Integer id) {
        return predictionTypeRepository.getById(id);
    }

    @Override
    public Prediction savePrediction(Prediction prediction) {
        return predictionRepository.save(prediction);
    }
}
