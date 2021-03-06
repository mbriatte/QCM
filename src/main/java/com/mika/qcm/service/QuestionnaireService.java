package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;


public interface QuestionnaireService {

	 /**
    sauvegarde un nouveau questionnaire en base ainsi que ses assocations si celles ci ne le sont pas déjà
    @param le questionnaire à sauvegarder
	 */
	void addQuestionnaire(Questionnaire q);
	
	 /**
    sauvegarde un  questionnaire en base ainsi que ses assocations si celles ci ne le sont pas déjà
    @param le questionnaire à sauvegarder
	 */
	void saveQuestionnaire(Questionnaire q);
	
	 /**
    supprime un  questionnaire et ses association
    @param l'identifiant du questionnaire à supprimer
	 */
	void removeQuestionnaire(Long idquestionnaire);
	
	/**
    retourne la liste des questionnaires
    @return la liste des questionnaires
	 */
	List<Questionnaire> getQuestionnaires();
	
	/**
    recherche un questionnaire selon son identifiant
    @param l'identifiant du questionnaire à rechercher
    @return le questionnaire recherché
	 */
	Questionnaire getQuestionnaire(Long idquestionnaire);
	
	/**
    recherche le 1er questionnaire selon un libelle
    @param le libelle du questionnaire recherché
    @return le 1Er questionnaire ayant ce libelle
	 */
	Questionnaire getQuestionnaireByName(String questionnaire);
	
	/**
    recherche le 1er questionnaire selon un libelle en chargant ses associations
    @param le libelle du questionnaire recherché
    @return le 1Er questionnaire ayant ce libelle
	 */
	Questionnaire getQuestionnaireWithAssociationByName(String questionnaire);
	
	/**
    ajoute une question à un questionnaire
    @param  q la question à ajouter
    @param  idquestionnaire lidentifiant du questionnaire sur lequel ajouter la question
	 */
	void addQuestionToQuestionnaire(Question q, Long idquestionnaire);
	
	/**
    supprime une question sur un questionnaire
    @param  idquestion l'identifiant de la question à supprimer
    @param  idquestionnaire l'identifiant du questionnaire sur lequel supprimer la question
	 */
	void removeQuestionFromQuestionnaire( Long idquestion , Long idquestionnaire);	

	/**
    retourne les questions associées à un questionnaire
    @param  idquestionnaire l'identifiant du questionnaire
     @return la liste des questions
	 */
	List<Question> getQuestions(Long idquestionnaire);
	
}
