package pro.sky.sky.pro.CourseNumber2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Exception.DataNotFound;
import pro.sky.sky.pro.CourseNumber2.Exception.NotNullDataException;
import pro.sky.sky.pro.CourseNumber2.Service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JavaQuestionServiceSingleTest {

    static final JavaQuestionService javaQuestionService  = new JavaQuestionService();

    @BeforeEach
    public void setUp(){
        javaQuestionService.add(new Question("QuestionText111","QuestionAnswer111"));
        javaQuestionService.add(new Question("QuestionText121","QuestionAnswer121"));
        javaQuestionService.add(new Question("QuestionText131","QuestionAnswer131"));
        javaQuestionService.add(new Question("QuestionText141","QuestionAnswer141"));
        javaQuestionService.add(new Question("QuestionText151","QuestionAnswer151"));
        javaQuestionService.add(new Question("QuestionText161","QuestionAnswer161"));
    }

    @Test
    public void JavaQuestionServiceTestRemove(){
        Question questionTest = javaQuestionService.getRandomQuestion(1);
        Assertions.assertEquals(questionTest,javaQuestionService.remove(questionTest));
    }

    @Test
    public void JavaQuestionServiceTestRemoveNotNullDataException(){
        assertDoesNotThrow(NotNullDataException::new, String.valueOf(javaQuestionService.remove(new Question("QuestionText161","QuestionAnswer161")))) ;
    }

    @Test
    public void JavaQuestionServiceTestRemoveDataNotFound(){
        assertDoesNotThrow(DataNotFound::new, String.valueOf(javaQuestionService.remove(new Question("QuestionText141","QuestionAnswer141")))) ;
    }
}
