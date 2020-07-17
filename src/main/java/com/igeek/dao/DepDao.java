package com.igeek.dao;

import com.igeek.pojo.Dep;

import java.util.List;

public interface DepDao {

    public List<Dep> findAll();

    public Dep findByDepId(int depId);
}
