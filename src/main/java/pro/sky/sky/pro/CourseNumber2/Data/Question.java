package pro.sky.sky.pro.CourseNumber2.Data;

import org.springframework.stereotype.Repository;

@Repository
public class Question {
    private String question;
    private String answer;
    public Question(String question,String answer){
        this.question = question;
        this.answer = answer;
    }

    public Question(){

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean equals(@org.jetbrains.annotations.NotNull Question question) {
        return getQuestion().equals(question.getQuestion()) && getAnswer().equals(question.getAnswer());
    }


    @Override
    public int hashCode() {
        return question.hashCode() + answer.hashCode();
    }

    @Override
    public String toString() {
        return "{question: " + question +", answer: " + answer + "}";
    }


}
