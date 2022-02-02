package pro.sky.sky.pro.CourseNumber2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Service.JavaQuestionService;

@RestController
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "add")
    public String add(String question,String answer){
        return javaQuestionService.add(question,answer).toString();
    }

    @GetMapping(path = "remove")
    public String remove(String question,String answer){
        Question questionObject = new Question(question,answer);
        return javaQuestionService.remove(questionObject).toString();
    }

    @GetMapping(path = "/")
    public String getAll(){
        return javaQuestionService.getAll().toString();
    }
}
