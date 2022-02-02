package pro.sky.sky.pro.CourseNumber2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotNullDataException extends RuntimeException{
}
