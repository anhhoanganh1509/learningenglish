package vn.springhibernate.hoanganh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.model.LearningEnglish;
import vn.springhibernate.hoanganh.model.ViewTotalVocabularyCopy;

@Repository
@Transactional(rollbackFor = Exception.class)
public class LearningEnglishDao {
	@Autowired
	private SessionFactory sessionFactory;	

	public List<ViewTotalVocabularyCopy> findByViewId(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+ViewTotalVocabularyCopy.class.getName(), ViewTotalVocabularyCopy.class).getResultList();
	}
	
	public List<LearningEnglish> findByChaId(final String chaId){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+LearningEnglish.class.getName()
				+" where chaid = '"+chaId+"' order by id asc", LearningEnglish.class).getResultList();
	}
	
	public void updateLearningEnglish(LearningEnglish e) {
		Session session = this.sessionFactory.getCurrentSession();
		if(e.getVietnamese().length() != 0) {
			e.setVietnamese("");
			e.setState(1);
		}else {
			e.setVietnamese(e.getVietnamesecopy());
			e.setState(0);
		}
		session.update(e);
	}

	public LearningEnglish findById(final String id){
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(LearningEnglish.class, Integer.parseInt(id));
	}

	public List<LearningEnglish> findByChaIdAndState(final String chaId, final String state){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+LearningEnglish.class.getName()
				+" where chaid = '"+chaId+"' and state = "+state+" order by id asc", LearningEnglish.class).getResultList();
	}
	
}
