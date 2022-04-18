// package site.metacoding.animalprojectfrontend.handler;

// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import site.metacoding.animalprojectfrontend.web.api.dto.ResponseDto;

// @RestControllerAdvice
// public class ErrorHandler {

// @ExceptionHandler(value = RuntimeException.class)
// public ResponseDto<String> error1(RuntimeException e) {
// return new ResponseDto<String>(-1, "실패", e.getMessage());
// }

// }