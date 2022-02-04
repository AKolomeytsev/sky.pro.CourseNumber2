package pro.sky.sky.pro.CourseNumber2.Service;

import org.springframework.stereotype.Service;
import pro.sky.sky.pro.CourseNumber2.Data.Question;
import pro.sky.sky.pro.CourseNumber2.Exception.DataNotFound;
import pro.sky.sky.pro.CourseNumber2.Exception.DublicateException;
import pro.sky.sky.pro.CourseNumber2.Exception.NotNullDataException;
import pro.sky.sky.pro.CourseNumber2.Interface.IQuestionService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class JavaQuestionService implements IQuestionService {

    private final Map<Integer,Question> questions;
    static int id;

    public JavaQuestionService() {
        this.questions = new HashMap<>();
    }

    @Override
    public String toString() {
        return questions.toString();
    }

    private int genId(){
        return id++;
    }

    @Override
    public Question add(String question, String answer) {
        Question item;
        if(question!=null && answer!=null){
            item = new Question(question,answer);
            if(!isDublicate(item)){
                questions.put(genId(),item);
            }else{
                throw new DublicateException();
            }
        }else{
            throw new NotNullDataException();
        }
        return item;
    }

    private boolean isDublicate(Question question) {
        boolean isFound = false;
        if(dataFound(question)>-1)
                isFound = true;
        return isFound;
    }

    @Override
    public Question add(Question question) {
        if(question!=null){
            if(!isDublicate(question)){
                questions.put(genId(),question);
            }else{
                throw new DublicateException();
            }
        }else{
            throw new NotNullDataException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(question!=null){
            int index = dataFound(question);
            if(index>-1){
                questions.remove(index);
            }else{
                throw new DataNotFound();
            }
        }else{
            throw new NotNullDataException();
        }
        return question;
    }

    private int dataFound(Question question) {
        for(Map.Entry<Integer, Question> item:questions.entrySet()){
            if(question.equals(item.getValue())){
                return item.getKey();
            }
        }
        return -1;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.values();
    }

    @Override
    public Question getRandomQuestion(int count) {
        Random index = new Random();
        return questions.get(index.nextInt(count));
    }
}
