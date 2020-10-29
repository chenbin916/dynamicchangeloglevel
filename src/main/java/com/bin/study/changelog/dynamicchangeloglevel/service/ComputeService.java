package com.bin.study.changelog.dynamicchangeloglevel.service;



import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputeService {

    private  final  static Logger log= LoggerFactory.getLogger(ComputeService.class);

       public int  compute(int  m)
       {
              int res=0;
              log.info("service computer invoke");

              if(log.isDebugEnabled())
                  System.out.println("param m is :"+m);
              try {
                  res = 1 / m;
              }catch ( Exception ex)
              {

              }
           return res;

       }

    public  String  changeLevel(String className,int  level)
    {
        String res="";
        LoggerContext  context= (LoggerContext) LoggerFactory.getILoggerFactory();

        if ( null==className||"".equalsIgnoreCase(className))
            return "set failure,className is null";
        ch.qos.logback.classic.Logger  vlogger = context.getLogger(className);

        if("root".equalsIgnoreCase(className))
             res=  "cann't set root level";
         else
          {

                  res="原来级别："+vlogger.getLevel();
                  vlogger.setLevel(Level.toLevel(level));
                  log.info("更改了"+className+"的日志级别");
                  res=res+"更改后的级别为："+vlogger.getLevel();



          }
        List<ch.qos.logback.classic.Logger> loggerList=context.getLoggerList();
        for (ch.qos.logback.classic.Logger log:loggerList)
            log.info(log.getName()+"level is :"+log.getLevel()); //默认都是没有值得，只有root才有。因为logback-spring.xml没有配置
       return res;
    }
}
