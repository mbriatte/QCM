package com.mika.qcm.dao;

import com.mika.qcm.model.Questionnaire;

public interface QuestionnaireDao extends GenericDao<Questionnaire, Long>{

	 Questionnaire findBynamewithAssociation(String questionnaire);

}
