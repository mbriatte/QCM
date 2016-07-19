package main.java.com.mika.qcm.dao.impl;


import org.hibernate.SessionFactory;

import main.java.com.mika.qcm.dao.QuestionnaireDao;
import main.java.com.mika.qcm.model.Questionnaire;



public class QuestionnaireDaoImpl extends GenericDaoImpl<Questionnaire, Long> implements QuestionnaireDao {

	@Override
	
	public Questionnaire findByNameWithAssociations(String questionnaire) {
		SessionFactory sessionf = this.getSessionFactory();
		String query = "select q from Questionnaire q left join fetch q.questions a where q.libelle = :libelle";		
		return (Questionnaire) sessionf.getCurrentSession().createQuery(query).setParameter("libelle", questionnaire).setMaxResults(1).uniqueResult();
	}

}
