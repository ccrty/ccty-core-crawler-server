package com.ccty.noah.controller;

import com.ccty.noah.aop.aspect.NoahResult;
import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 缄默
 * @date 2019/5/23
 */
@Api("示例控制器")
@RequestMapping("/{version}/api/crawler")
@NoahController
@Slf4j
public class DemoController {


    @ApiOperation(value = "异常抛出示例", notes = "异常抛出示例")
    @GetMapping("/test")
    public NoahResult test(){
        throw new NoahException("001","示例");
    }

    @ApiOperation(value = "正常返回示例", notes = "正常返回示例")
    @GetMapping("/test1")
    public NoahResult<String> test1(){
        return NoahResult.builderSuccess(StringUtils.EMPTY);
    }

}
