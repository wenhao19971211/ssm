import com.igeek.pojo.Dep;
import com.igeek.pojo.Emp;
import com.igeek.pojo.User;
import com.igeek.service.DepService;
import com.igeek.service.EmpService;
import com.igeek.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Demo {
    @Autowired
    UserService userService;
    @Autowired
    DepService depService;
    @Autowired
    EmpService empService;
    @Test
    public void test(){
//        User user = userService.findByName("admin");
//        System.out.println(user.getUserId()+"\t"+user.getPassword());
//        Dep dep = depService.depInfo(50);
//        System.out.println(dep.getDepId()+"\t"+dep.getAvgSalary()+"\t"+dep.getEmpCount());
//        List<Emp> list = empService.findByDepId(50);
//        for (Emp emp : list) {
//            System.out.println(emp.getEmpName());
//        }
        empService.updateSalary(1001,5000);
    }
}
