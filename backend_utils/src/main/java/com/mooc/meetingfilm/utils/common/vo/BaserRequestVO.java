package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @author : Z
 * @program : com.mooc.meetingfilm.utils.common.vo
 * @description : 公共的请求对象
 **/
public abstract class BaserRequestVO {

    /**
    * @Description: 公共的参数验证方法
    * @Param: []
    * @return: void
    * @Author: Z
    */
    public abstract void checkParam() throws CommonServiceException;

}
