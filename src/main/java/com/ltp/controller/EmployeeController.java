package com.ltp.controller;

import com.ltp.dao.DepartmentDao;
import com.ltp.dao.EmployeeDao;
import com.ltp.model.Department;
import com.ltp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * @return String
     * @Author Ltp
     * @Description 查询所有员工
     * @Date 2019/4/21 14:32
     * @Param
     **/
    @GetMapping(value = "/emps")
    public String queryAllEmps(Model model) {
        //获取所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //将数据放入请求域中
        model.addAttribute("employees", employees);
        //thymeleaf模板引擎会自动拼串：classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * @return String
     * @Author Ltp
     * @Description 跳转到添加页面
     * @Date 2019/4/21 15:38
     * @Param model
     **/
    @GetMapping(value = "/emp")
    public String addEmployeePage(Model model) {
        //查出所有部门名称
        Collection<Department> departments = departmentDao.getDepartments();
        //将数据放入请求域中
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    /**
     * @return String
     * @Author Ltp
     * @Description 添加员工
     * @Date 2019/4/21 15:38
     * @Param
     **/
    @PostMapping(value = "/emp")
    //SpringMVC自动封装数据
    public String addEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
