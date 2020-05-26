package com.jianmo.crawler.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * 任务执行类
 * @author 缄默
 * @date 2019/5/17
 */
@JobHandler(value="activity")
@Component
public class ActivityJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        return new ReturnT(200, "执行成功");
    }
}