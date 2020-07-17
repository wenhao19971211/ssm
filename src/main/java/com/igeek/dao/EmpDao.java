package com.igeek.dao;

import com.igeek.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {

    public List<Emp> findByDepId(int depId);

    public void updateSalary(@Param("empId") int empId,@Param("salary") double salary);
}
