package py.com.jacaceres.cache.cachingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@ComponentScan("py.com.jacaceres")
public class CachingDataApplication {

    public static void main(String[] args) {
            SpringApplication.run(CachingDataApplication.class, args);
    }

}
