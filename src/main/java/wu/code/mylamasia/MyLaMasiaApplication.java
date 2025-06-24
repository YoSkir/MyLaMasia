package wu.code.mylamasia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "module")
public class MyLaMasiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLaMasiaApplication.class, args);
    }

}
