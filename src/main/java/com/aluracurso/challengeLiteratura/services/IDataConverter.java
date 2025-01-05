package com.aluracurso.challengeLiteratura.services;

public interface IDataConverter {
    <T> T getData(String json, Class<T> clase);
}
