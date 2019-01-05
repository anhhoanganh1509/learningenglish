package vn.springhibernate.hoanganh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.dao.LearningEnglishDao;
import vn.springhibernate.hoanganh.model.LearningEnglish;

@Service
@Transactional
public class LearningEnglishService {
	
	@Autowired
	private LearningEnglishDao eDao;
	
	public List<LearningEnglish> finByChaId(final String chaId) {
		return eDao.findByChaId(chaId);
	}
	
	public void updateLearningEnglish(LearningEnglish e) {
		eDao.updateLearningEnglish(e);
	}
	
	public LearningEnglish findById(final String id){
		return eDao.findById(id);
	}

	public List<LearningEnglish> findByChaIdAndState(final String chaId, final String state) {
		return eDao.findByChaIdAndState(chaId, state);
	}
	
}
