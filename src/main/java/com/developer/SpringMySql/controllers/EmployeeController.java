package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.Repo.DepartmentRepo;
import com.developer.SpringMySql.Repo.EmployeeRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.EmployeeDto;
import com.developer.SpringMySql.dto.EmployeeMapDto;
import com.developer.SpringMySql.models.Employee;
import com.developer.SpringMySql.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.developer.SpringMySql.services.EmployeeService;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentService departmentService;

        @RequestMapping( value = "/emp")
        public ModelAndView doHome(@ModelAttribute("employeeModel") EmployeeDto employeeDto, Pageable pageable) {
            ModelAndView mv = new ModelAndView("Employee/index");
            EmployeeMapDto result = employeeService.search(employeeDto,pageable);
            List<DepartmentDto> depart = departmentService.getAll();
            mv.addObject("employee", result.getDtoList());
            mv.addObject("totalItems",result.getNumberOfItems());
            mv.addObject("department", depart);

            return mv;
        }

        @RequestMapping(value = "/Employee/create")
            public ModelAndView doCreate(){
            ModelAndView mv = new ModelAndView("Employee/add");
            return mv;
        }

        @RequestMapping(value = "/Employee/view/{empId}",method = RequestMethod.GET)
        public ModelAndView doView(@PathVariable("empId") int empId) {
        ModelAndView mv = new ModelAndView("Employee/view");
        Optional<EmployeeDto> emp = employeeService.findById(empId);
        if (emp.isPresent()){
            mv.addObject("employee", emp.get());
        }else{
            System.out.println("nothing id here");
        }
        return mv;
        }

        @RequestMapping(value ="/Employee/save",method = RequestMethod.POST)
        public ModelAndView doSave(@RequestParam("emp_name") String emp_name,
                                   @RequestParam("age")String age, @RequestParam("sex") String sex,
                                   @RequestParam("birthday") String birthday, @RequestParam("departId") String departId) throws ParseException {
                ModelAndView mv = new ModelAndView("redirect:/emp");

            Employee employee = new Employee();
            employee.setEmpName(emp_name);
            employee.setAge(Integer.parseInt(age));
            employee.setSex(Integer.parseInt(sex));
            SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
            employee.setBirthday(frm.parse(birthday));
            employee.setDepartId(Integer.parseInt(departId));
            employeeRepo.save(employee);


            return mv;
        }

        @RequestMapping(value = "/Employee/edit/{empId}", method = RequestMethod.GET)
        public ModelAndView showUpdate(@PathVariable("empId") int empId){
            ModelAndView mv = new ModelAndView("Employee/edit");
            List<DepartmentDto> depart = departmentService.getAll();
            mv.addObject("department", depart);
            Optional<EmployeeDto> emp = employeeService.findById(empId);
            mv.addObject("employee", emp.get());
            return mv;
    }

        @RequestMapping(value ="/Employee/update",method = RequestMethod.POST)
        public ModelAndView doUpdate(@RequestParam("emp_id") String emp_id,@RequestParam("emp_name") String emp_name,
                                 @RequestParam("age")String age, @RequestParam("sex") String sex,
                                 @RequestParam("birthday") String birthday, @RequestParam("departId") String departId) throws ParseException {
            ModelAndView mv = new ModelAndView("redirect:/emp");
            Employee employee = new Employee();
            employee.setEmpId(Integer.parseInt(emp_id));
            employee.setEmpName(emp_name);
            employee.setAge(Integer.parseInt(age));
            employee.setSex(Integer.parseInt(sex));
            SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
            employee.setBirthday(frm.parse(birthday));
            employee.setDepartId(Integer.parseInt(departId));
            employeeRepo.save(employee);
            return mv;

        }


    @RequestMapping(value = "/Employee/delete/{empId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("empId") int empId){
        ModelAndView mv = new ModelAndView("redirect:/emp");
        employeeService.deleteById(empId);
        return mv;
    }


}
