package br.com.libcrud.application;

public interface UseCase<I, O> {

    O execute(I input);
}
