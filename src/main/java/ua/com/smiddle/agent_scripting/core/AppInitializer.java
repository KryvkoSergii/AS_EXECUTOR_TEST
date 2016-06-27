package ua.com.smiddle.agent_scripting.core;


import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Created by srg on 27.06.16.
 */

public class AppInitializer {
//
//    @Autowired
//    private static Environment environment;

    public static void main(String[] args) {

//        ApplicationContext ctx = SpringApplication.run(AppInitializer.class, args);
        Executor e = new Executor();
        e.prepare();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        e.removeUsers();
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
//        ctx.getBean("Executor");
    }

//    @Bean
//    public static Executor getExecutor(){
//        System.out.println(environment.getProperty("host_url"));
//        return new Executor();
//    }
}
