package pro.sky.sky.pro.CourseNumber2.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.sky.pro.CourseNumber2.Data.Question;

@Configuration
public class ConfigAppQuestion {
    public class ConfigAppBasket {
        @Bean
        public Question createQuestion(){
            return  new Question();
        }
    }
}

