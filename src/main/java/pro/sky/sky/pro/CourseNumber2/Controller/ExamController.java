package pro.sky.sky.pro.CourseNumber2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "exam")
    public Collection<Question> exam(int count){
        return examinerService.getQuestions(count);
    }
}
