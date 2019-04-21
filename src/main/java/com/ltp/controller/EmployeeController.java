package com.ltp.controller;

import com.ltp.dao.DepartmentDao;
import com.ltp.dao.EmployeeDao;
import com.ltp.model.Department;
import com.ltp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * @return String
     * @Author Ltp
     * @Description 跳转到修改员工页面
     * @Date 2019/4/21 15:38
     * @Param
     **/
    @GetMapping(value = "/emp/{id}")
    //SpringMVC自动封装数据
    public String updateEmployeePage(@PathVariable(value = "id") Integer id,Model model) {
        //查询对应ID的员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        //查出所有部门名称
        Collection<Department> departments = departmentDao.getDepartments();
        //将数据放入请求域中
        model.addAttribute("departments", departments);
        return "emp/add";
    }
    /**
     * @return String
     * @Author Ltp
     * @Description 修改员工信息
     * @Date 2019/4/21 15:38
     * @Param employee 封装员工信息
     **/
    @PutMapping(value = "/emp")
    //SpringMVC自动封装数据
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**
     * @return String
     * @Author Ltp
     * @Description 删除员工信息
     * @Date 2019/4/21 15:38
     * @Param id 员工编号
     **/
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
