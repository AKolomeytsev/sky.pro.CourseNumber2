package pro.sky.sky.pro.CourseNumber2.Interface;

import pro.sky.sky.pro.CourseNumber2.Data.Question;

import java.util.Collection;

public interface IExaminerService {
    Collection<Question> getQuestions(int count);
}
