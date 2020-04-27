package com.zhaoning.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.expr.NewArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoning
 * @date 2020/4/27 - 13:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDTO {
    private List<QuestionDTO> questionDTOS;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalpage;


    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page=page;

        if(totalCount %size==0){
            totalpage = totalCount/size;
        }else{
            totalpage = totalCount/size +1;
        }



        pages.add(page);
        for (int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);
            }
            if (page+i<=totalpage){
                pages.add(page+i);
            }
        }


        //是否展示上一页
        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious=true;
        }

        //是否展示下一页
        if(page == totalpage){
            showNext=false;
        }else{
            showNext = true;
        }

        //是否展示第一页
        if(pages.contains(1)) {
            showFirstPage = false;

        }else {
            showFirstPage =true;
        }

        //是否展示最后一页

        if(pages.contains(totalpage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }

    }
}
