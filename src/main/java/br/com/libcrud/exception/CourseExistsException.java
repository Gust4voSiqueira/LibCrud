package br.com.libcrud.exception;

public class CourseExistsException extends RuntimeException {

    public CourseExistsException(String message) {
        super(message);
    }
}
