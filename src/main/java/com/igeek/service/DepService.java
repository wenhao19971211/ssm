package com.igeek.service;

import com.igeek.dao.DepDao;
import com.igeek.pojo.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {
    @Autowired
    private DepDao depDao;

    public List<Dep> findAll(){
        return depDao.findAll();
    }

    public Dep depInfo(int depId){
        return depDao.findByDepId(depId);
    }
}
