package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.RestaurantNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestaurantErrorAdvice {
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleNotFound() {
        return "{}";
    }
}
