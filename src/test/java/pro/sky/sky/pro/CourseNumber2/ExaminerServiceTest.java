package pro.sky.sky.pro.CourseNumber2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Exception.TooManyQuestionsException;
import pro.sky.sky.pro.CourseNumber2.Service.ExaminerService;
import pro.sky.sky.pro.CourseNumber2.Service.JavaQuestionService;

import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private  ExaminerService examinerService;

    @BeforeEach
    void setUp(){
        Mockito.when(javaQuestionService.getRandomQuestion(5)).thenReturn(
                new Question("QuestionText","QuestionAnswer")
                ,new Question("QuestionText1","QuestionAnswer1")
                ,new Question("QuestionText2","QuestionAnswer2")
                ,new Question("QuestionText3","QuestionAnswer3")
                ,new Question("QuestionText11","QuestionAnswer11")
                ,new Question("QuestionText4","QuestionAnswer4")
                ,new Question("QuestionText5","QuestionAnswer5")
        );
    }

    @Test
    public void ExaminerServiceTestTooManyQuestionsException(){
        Assertions.assertThrows(TooManyQuestionsException.class,()->examinerService.getQuestions(10));
    }

    @Test
    public void ExaminerServiceTestGet(){
        Assertions.assertNotNull(examinerService.getQuestions(5));
    }

}
