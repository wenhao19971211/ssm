package com.igeek.handler;

import com.igeek.dto.TransferObj;
import com.igeek.pojo.Dep;
import com.igeek.pojo.Emp;
import com.igeek.redis.RedisUtil;
import com.igeek.service.DepService;
import com.igeek.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepHandler {
    @Autowired
    private DepService depService;
    @Autowired
    private EmpService empService;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("init")
    public TransferObj findDep(){
        TransferObj transferObj = new TransferObj();
        List<Dep> list = depService.findAll();
        redisUtil.set("depList",list,60*60*24);
        transferObj.setResult(list);
        return transferObj;
    }
    @GetMapping("depInfo")
    public TransferObj depInfo(int depId){
        TransferObj transferObj = new TransferObj();
        Dep dep = depService.depInfo(depId);
        transferObj.setResult(dep);
        transferObj.setCode(1);
        return transferObj;
    }
    @GetMapping("selectEmp")
    public TransferObj selectEmp(int depId){
        TransferObj transferObj = new TransferObj();
        List<Emp> list = empService.findByDepId(depId);
        redisUtil.set("empList",list,60*60);
        transferObj.setResult(list);
        return transferObj;
    }
    @PutMapping("updateSalary")
    public TransferObj updateSalary(int empId,double salary){
        TransferObj transferObj = new TransferObj();
        empService.updateSalary(empId,salary);
        List<Emp> list = (List<Emp>) redisUtil.get("empList");
        for (Emp emp : list) {
            if (emp.getEmpId() == empId){
                emp.setSalary(salary);
            }
        }
        redisUtil.set("empList",list);
        transferObj.setCode(1);
        return transferObj;
    }
}
