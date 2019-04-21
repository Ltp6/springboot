package com.ltp.controller;

import com.ltp.dao.EmployeeDao;
import com.ltp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Auther Ltp
 * @Date 2019/4/21 14:30
 * @Description 员工控制器
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    /**
     * @Author Ltp
     * @Description 查询所有员工
     * @Date 2019/4/21 14:32
     * @Param
     * @return String
     **/
    @GetMapping(value = "/emps")
    public String queryAllEmps(Model model){
        //获取所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //将数据放入请求域中
        model.addAttribute("employees",employees);
        //thymeleaf模板引擎会自动拼串：classpath:/templates/xxx.html
        return "emp/list";
    }
    /**
     * @Author Ltp
     * @Description 跳转到添加页面
     * @Date 2019/4/21 15:38
     * @Param
     * @return String
     **/
    @GetMapping(value = "/emp")
    public String addEmployeePage(){
        System.out.println("我来了");
        return "emp/add";
    }
}
