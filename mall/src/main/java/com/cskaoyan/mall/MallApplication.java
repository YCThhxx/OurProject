package com.cskaoyan.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
<<<<<<< HEAD
@MapperScan("com.cskaoyan.mall")
=======
@MapperScan(basePackages = "com.cskaoyan.mall.mapper")

@EnableTransactionManagement
>>>>>>> 1023ac2bdf72d30c8e853f5f3e1c340fb64fd3e2
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
