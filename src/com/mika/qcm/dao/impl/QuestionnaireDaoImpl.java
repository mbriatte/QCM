package com.mika.qcm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Questionnaire;

public class QuestionnaireDaoImpl extends GenericDaoImpl<Questionnaire, Long> implements QuestionnaireDao {

	@Override
	public Questionnaire findBynamewithAssociation(String questionnaire) {
		SessionFactory sessionf = this.getSessionFactory();
	
		String query = "select q from Questionnaire q left join fetch q.questions a where q.libelle = :libelle";
		
		return (Questionnaire) sessionf.getCurrentSession().createQuery(query).setParameter("libelle", questionnaire).setMaxResults(1).uniqueResult();
	}

}
