package com.keny.api.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceExceptionRendler extends ResponseEntityExceptionHandler {
	
	private MessageSource messageSource;

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {
		String userMessage = "Não encontrado o parâmetro de pesquisa";
		return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		String userMessage = "Existe campos obrigatórios não declarados";
		return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
	}

	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String userMessage = "Tipo de mídia HTTP não suportada" ;
		return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
	}
	
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
		String userMessage = "Entrada de dados em duplicidade";
		return handleExceptionInternal(ex, userMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		messageSource = new ReloadableResourceBundleMessageSource();
		List<String> erros = new ArrayList<String>();		
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			erros.add(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
		}
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
	}
	
}
