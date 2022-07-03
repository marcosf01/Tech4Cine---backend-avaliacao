package br.com.tech4me.informacoes.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TratamentoErrosFilmes extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> mensagensErro = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(m -> String.format("O campo %s está com erro %s", m.getField(), m.getDefaultMessage()) )
        .collect(Collectors.toList());
        return new ResponseEntity<>(mensagensErro, HttpStatus.NOT_ACCEPTABLE);
    }
}
