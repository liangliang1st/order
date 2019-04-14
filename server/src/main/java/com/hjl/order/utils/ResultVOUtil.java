package com.hjl.order.utils;

import com.hjl.order.viewobject.ResultVO;
import lombok.Data;

/**
 * @ClassName ResultVOUtil
 * @AUthor hanjialiang
 * @Date 2019-04-10 21:23
 * @Version 1.0
 * @Description
 */
@Data
public class ResultVOUtil {
    public static ResultVO success(Object o){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }
}
