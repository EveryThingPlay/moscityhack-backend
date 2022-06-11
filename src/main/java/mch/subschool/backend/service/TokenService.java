package mch.subschool.backend.service;

import mch.subschool.backend.common.ProtectedWebResource;

import java.util.function.Function;

public interface TokenService {
    boolean isTokenAdmittedForResource(String token, ProtectedWebResource resource);
    <T,R> R getResultIfTokenValid(String token, ProtectedWebResource resource, Function<T, R> function, T input) throws IllegalAccessException;
}
