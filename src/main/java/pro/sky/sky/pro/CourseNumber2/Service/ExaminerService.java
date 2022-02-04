package pro.sky.sky.pro.CourseNumber2.Service;

import org.springframework.stereotype.Service;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Exception.TooManyQuestionsException;
import pro.sky.sky.pro.CourseNumber2.Interface.IExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerService implements IExaminerService {
    private final JavaQuestionService javaQuestionService;


    public ExaminerService(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int count) {
        Set<Question> questions = new HashSet<>();
        if(javaQuestionService.getAll().size()<count) {
            throw new TooManyQuestionsException();
        }else{
            while (questions.size() < count) {
                Question item = javaQuestionService.getRandomQuestion(count);
                questions.add(item);
            }
        }
        return questions;
    }
}
