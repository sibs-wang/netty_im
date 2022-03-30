package com.wang.rest;

import com.wang.domain.application.QuestionnaireService;
import com.wang.rest.request.QuestionnaireResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class QuestionnaireRestController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireRestController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/")
    public QuestionnaireResponse findQuestionnaire(String id) {
        // 就是查询三次数据库,然后
        // 应该是这样的,根据id查出问题list,根据id和问卷id查出选项,然后前端或者后端进行组合处理
        // 但是还有个问题那就是答题答道一半结果怎么保存的问题,额外设计一张表,把无用的信息保存起来,否则就需要两站表联查
        // 怎么解决联查问题? 左表的id != 右表的id
        return null;
    }
}
