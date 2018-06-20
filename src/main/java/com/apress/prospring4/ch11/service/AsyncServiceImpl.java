package com.apress.prospring4.ch11.service;


import com.apress.prospring4.ch11.service.interfaces.AsyncService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service("asyncService")
public class AsyncServiceImpl implements AsyncService{

    private static final Logger LOG = Logger.getLogger(AsyncService.class);

    @Async
    public void asyncTask() {

        LOG.info("Start execution of asyncTask ~~");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("Complete of execution asyncTask");

    }

    public Future<String> asyncWithReturn(String name) {
        LOG.info("Start of execution asyncWithReturn ~~");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOG.info("End of execution asyncWithReturn");
        return new AsyncResult<String>("Hello "+name);
    }
}
