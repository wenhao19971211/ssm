package com.igeek.handler;

import com.igeek.dto.TransferObj;
import com.igeek.pojo.User;
import com.igeek.redis.RedisUtil;
import com.igeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("login")
    public TransferObj login(String userName, String password, HttpSession session){
        TransferObj transferObj = new TransferObj();
        User user = userService.findByName(userName);
        if (user != null){
            if (user.getPassword().equals(password)){
                session.setAttribute("loginUser",user);
                User loginUser = (User) session.getAttribute("loginUser");
                System.out.println(loginUser.getUserName());
                transferObj.setCode(0);
            }
            else{
                transferObj.setCode(1);
                transferObj.setMessage("密码错误");
            }
        }
        else{
            transferObj.setCode(1);
            transferObj.setMessage("用户名错误");
        }
        return transferObj;
    }
}
