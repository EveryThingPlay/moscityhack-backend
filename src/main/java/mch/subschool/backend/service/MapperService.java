package mch.subschool.backend.service;

public interface MapperService<T, S> {
    T toDto(S model);
    S fromDto(T dto);
}
