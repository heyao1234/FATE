package com.webank.ai.fate.serving.core.bean;

import com.webank.ai.fate.core.bean.ReturnResult;
import com.webank.ai.fate.serving.core.monitor.WatchDog;
import com.webank.ai.fate.serving.core.utils.GetSystemInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuestInferenceLoggerPrinter implements  LoggerPrinter<Request,ReturnResult>{

    static final   String  LOGGER_NAME =  "flow";

    private static final Logger LOGGER = LogManager.getLogger(LOGGER_NAME);


    @Override
    public void printLog(Context context, Request req, ReturnResult resp) {


            LOGGER.info("{}|{}|{}|{}|{}|{}|{}|{}|{}", GetSystemInfo.getLocalIp(),context.getSeqNo(), req != null ? ((Request) req).getCaseid() : "NONE", context.getActionType(), context.getCostTime(),
                    resp != null ? resp.getRetcode() : "NONE", WatchDog.get(), req,resp);

        }
}

