# dynamicchangeloglevel
Springboot项目，动态改变某个类的日志级别。

1.项目上生产后，有Bug不方便调试，看日志又没信息时，如在在代码中留好后门，就可以利用本项目方法
动态改变某个类的日志级别，如：
if(log.isDebugEnabled()) System.out.println("param m is :"+m);
日志上生产时，日志级别一般都不能使Debug，所以上面调试语句是不会执行的。
2.改变日志级别的int level值为：10000  Debug;20000 Info;30000 Warn ;40000 Error，其他详见类Level.class
3. List<ch.qos.logback.classic.Logger> loggerList=context.getLoggerList();
        for (ch.qos.logback.classic.Logger log:loggerList)
            log.info(log.getName()+"level is :"+log.getLevel()); //默认都是没有值得，只有root才有。因为logback-spring.xml
4测试URL：http://localhost:8080/demo/compute?a=0，
          http://localhost:8080/demo/changeLevel?className=com.bin.study.changelog.dynamicchangeloglevel.service.ComputeService&level=10000
          

