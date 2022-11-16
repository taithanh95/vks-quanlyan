package com.bitsco.vks.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class BaseErrorHandles {

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMsg());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationException(MethodArgumentNotValidException ex) {
        log.error("Validation Error: ", ex);
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError: ex.getBindingResult().getAllErrors()) {
            sb.append(objectError.getDefaultMessage()).append("<br>");
        }
        map.put("message", "Dữ liệu đầu vào không hợp lệ");
        map.put("detail", sb.toString());
        return map;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Map<String, Object> handleAuthorizationException(AccessDeniedException ex) {
        log.error("Authorization Error: ", ex);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Người dùng không có quyền truy cập tài nguyên này");
        map.put("detail", ex.getMessage());
        return map;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public Map<String, Object> handleException(EntityNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Không tìm thấy bản ghi");
        log.error("Entity not found", exception);
        return map;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoResultException.class)
    public Map<String, Object> handleException(NoResultException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Không tìm thấy bản ghi");
        log.error("Entity not found", exception);
        return map;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleGeneralException(Exception ex) {
        log.error("General Error: ", ex);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Lỗi hệ thống, vui lòng thử lại sau");
        map.put("detail", ex.getMessage());
        return map;
    }
}
