package pro.sky.sky.pro.CourseNumber2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Exception.DublicateException;
import pro.sky.sky.pro.CourseNumber2.Exception.NotNullDataException;
import pro.sky.sky.pro.CourseNumber2.Service.JavaQuestionService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JavaQuestionServiceTest {
    static final JavaQuestionService javaQuestionService  = new JavaQuestionService();

    public static Stream<Question> providerParametrsForJavaQuestionServiceTestAddDublicateException(){
        return Stream.of(
                new Question("QuestionText","QuestionAnswer")
                ,new Question("QuestionText1","QuestionAnswer1")
                ,new Question("QuestionText2","QuestionAnswer2")
                ,new Question("QuestionText3","QuestionAnswer3")
                ,new Question("QuestionText1","QuestionAnswer1")
                ,new Question("QuestionText4","QuestionAnswer4")
                ,new Question("QuestionText5","QuestionAnswer5")
        );
    }

    public static Stream<Question> providerParametrsForJavaQuestionServiceTestAddNotNullDataException(){
        return Stream.of(
                new Question("QuestionText11","QuestionAnswer11")
                ,new Question("QuestionText12","QuestionAnswer12")
                ,null
                ,new Question("QuestionText13","QuestionAnswer13")
                ,new Question("QuestionText14","QuestionAnswer14")
        );
    }

    public static Stream<Question> providerParametrsForJavaQuestionServiceTestAdd(){
        return Stream.of(
                new Question("QuestionText21","QuestionAnswer21")
                ,new Question("QuestionText22","QuestionAnswer22")
                ,new Question("QuestionText23","QuestionAnswer23")
                ,new Question("QuestionText24","QuestionAnswer24")
        );
    }

    @ParameterizedTest
    @MethodSource("providerParametrsForJavaQuestionServiceTestAdd")
    public void TestAddQuestion(Question question){
        Assertions.assertEquals(question,javaQuestionService.add(question));
    }

    @ParameterizedTest
    @MethodSource("providerParametrsForJavaQuestionServiceTestAddDublicateException")
    public void TestAddQuestionDuplicatedExeption(Question question){
        assertDoesNotThrow(DublicateException::new, String.valueOf(javaQuestionService.add(question))) ;
    }

    @ParameterizedTest
    @MethodSource("providerParametrsForJavaQuestionServiceTestAddNotNullDataException")
    public void TestAddQuestionNotNullDataException(Question question){
        assertDoesNotThrow(NotNullDataException::new, String.valueOf(javaQuestionService.add(question))) ;
    }


}
