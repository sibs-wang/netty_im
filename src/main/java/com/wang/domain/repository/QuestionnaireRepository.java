package com.wang.domain.repository;

import com.wang.domain.model.SurveyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<SurveyInfo, Integer> {

}
