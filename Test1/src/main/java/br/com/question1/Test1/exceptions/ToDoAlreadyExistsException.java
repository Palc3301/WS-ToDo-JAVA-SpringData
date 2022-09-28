package br.com.question1.Test1.exceptions;

public class ToDoAlreadyExistsException extends Exception {

	public ToDoAlreadyExistsException() {
	}

	public ToDoAlreadyExistsException(String message) {
		super(message);
	}
}
