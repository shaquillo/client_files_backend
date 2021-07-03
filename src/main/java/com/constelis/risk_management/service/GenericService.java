package com.constelis.risk_management.service;

import java.util.List;

public interface GenericService<TDto> {

    public TDto create(TDto tDto);

    public TDto find(String id);

    public List<TDto> findAll();

}
