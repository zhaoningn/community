package com.zhaoning.community.service;

import com.zhaoning.community.dto.PaginationDTO;
import com.zhaoning.community.dto.QuestionDTO;
import com.zhaoning.community.mapper.QuestionMapper;
import com.zhaoning.community.mapper.UserMapper;
import com.zhaoning.community.model.Question;
import com.zhaoning.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoning
 * @date 2020/4/26 - 19:50
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page,Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalpage;
        Integer totalCount = questionMapper.count();
        if(totalCount %size==0){
            totalpage = totalCount/size;
        }else{
            totalpage = totalCount/size +1;
        }

        if (page<1){
            page=1;
        }
        if (page>totalpage){
            page=totalpage;
        }

        paginationDTO.setPagination(totalpage,page);
        Integer pages = size * (page-1);

        List<Question> questions = questionMapper.list(pages,size);

        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
           User user = userMapper.findById(question.getCreater());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOS);


        return paginationDTO;



    }

    public PaginationDTO questionList(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalpage;

        Integer totalCount = questionMapper.questionCount(userId);


        if(totalCount %size==0){
            totalpage = totalCount/size;
        }else{
            totalpage = totalCount/size +1;
        }

        if (page<1){
            page=1;
        }
        if (page>totalpage){
            page=totalpage;
        }
        paginationDTO.setPagination(totalpage,page);

        Integer pages = size * (page-1);

        List<Question> questions = questionMapper.questionList(userId,pages,size);

        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreater());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOS);




        return paginationDTO;
    }

    public QuestionDTO getQuestionByid(Integer id) {
        Question question= questionMapper.getQuestionById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.findById(question.getCreater());
        questionDTO.setUser(user);
        return questionDTO;
    }


    public void CreatOrUpdate(Question question) {
        if (question.getId()==null){
            //创建
            question.setGmt_create(System.currentTimeMillis());
            question.setGmt_modified(question.getGmt_create());
            questionMapper.CreateQuestion(question);
        }else {
            //更新
            question.setGmt_modified(question.getGmt_create());
            questionMapper.update(question);
        }
    }
}
