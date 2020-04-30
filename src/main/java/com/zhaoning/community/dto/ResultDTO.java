package com.zhaoning.community.dto;


import com.zhaoning.community.exception.CustomizeErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSetMetaData;

/**
 * @author zhaoning
 * @date 2020/4/30 - 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }
}
