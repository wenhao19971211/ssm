package com.igeek.service;

import com.igeek.dao.EmpDao;
import com.igeek.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    public List<Emp> findByDepId(int depId){
        return empDao.findByDepId(depId);
    }

    public void updateSalary(int empId,double salary){
        empDao.updateSalary(empId,salary);
    }
}
