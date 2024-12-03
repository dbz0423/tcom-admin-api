package top.zhu.tcomadminapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.zhu.tcomadminapi.mapper")
public class TcomAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcomAdminApiApplication.class, args);
    }

}
