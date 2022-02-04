package pro.sky.sky.pro.CourseNumber2.Interface;

import pro.sky.sky.pro.CourseNumber2.Data.Question;

import java.util.Collection;

public interface IQuestionService {
    Question add(String question,String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion(int count);
}
