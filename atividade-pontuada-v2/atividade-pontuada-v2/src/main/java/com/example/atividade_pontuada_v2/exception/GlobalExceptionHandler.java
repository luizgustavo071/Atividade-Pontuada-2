package com.example.atividade_pontuada_v2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EmailDuplicadoException.class)
  public ResponseEntity<Map<String, String>> handleEmailDuplicado(EmailDuplicadoException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", ex.getMessage()));
  }

  @ExceptionHandler(EntidadeNaoEncontradaException.class)
  public ResponseEntity<Map<String, String>> handleNotFound(EntidadeNaoEncontradaException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensagem", ex.getMessage()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
    String erroMensagem = ex.getBindingResult().getFieldError().getDefaultMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erroMensagem));
  }
}
