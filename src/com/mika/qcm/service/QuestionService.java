package com.mika.qcm.service;

import com.mika.qcm.model.Question;


public interface QuestionService {
	void addQuestion(Question q);
	void removeQuestion(Question q);
	void removeQuestion(String idquestion);
}
