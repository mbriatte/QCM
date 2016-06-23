package com.mika.qcm.dao;

import com.mika.qcm.model.Questionnaire;

public interface QuestionnaireDao extends GenericDao<Questionnaire, Long>{
	 /**
    Recherche le premier questionnaire selon son libelle en chargant son association
    @param le libelle à chercher.
    @return le premier questionnaire.
	 */
	 Questionnaire findByNameWithAssociations(String questionnaire);

}
