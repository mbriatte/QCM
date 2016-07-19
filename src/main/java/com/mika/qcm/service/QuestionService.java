package main.java.com.mika.qcm.service;

import java.util.List;

import main.java.com.mika.qcm.model.Proposition;

import main.java.com.mika.qcm.model.Question;



public interface QuestionService {
	 /**
    sauvegarde un nouvelle questione en base ainsi que ses assocations si celles ci ne le sont pas déjé
    @param la question é sauvegarder
	 */
	void addQuestion(Question q);
	
	 /**
    supprime une question en base ainsi que ses assocations 
    @param l'identifiant de la question a supprimer
	 */
	void removeQuestion(Long idquestion);
	
	/**
    retourne la liste des question non associé é un questionnaire 
    @return la liste des questions
	 */
	List<Question> getQuestionWithoutQuestionnaire();
	
	/**
    ajoute une proposition é une question
    @param  p la proposition é ajouter
    @param  idquestion l'identifiant de la question sur lequel ajouter la proposition
	 */
	void addPropositionToQuestion(Proposition p, Long idquestion);
	
	/**
    supprime une proposition sur un question
    @param  idproposition l'identifiant de la proposition é supprimer
    @param  idquestion l'identifiant de la question sur lequel supprimer la proposition
	 */
	void removePropositionFromQuestion(Long idproposition, Long idquestion);
	
	 /**
    sauvegarde un  questione en base ainsi que ses associations si celles ci ne le sont pas déjé
    @param la question é sauvegarder
	 */
	void saveQuestion(Question q);
	
	/**
    recherche une question selon son identifiant
    @param l'identifiant de la question  é rechercher
    @return la question recherchée
	 */
	Question getQuestion(Long id);
	
	List<Question> getQuestions();
}
