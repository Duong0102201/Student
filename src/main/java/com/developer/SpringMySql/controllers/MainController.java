package com.developer.SpringMySql.controllers;

import com.developer.SpringMySql.Repo.DepartmentRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.DepartmentMapDto;
import com.developer.SpringMySql.models.Department;
import com.developer.SpringMySql.services.DepartmentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    DepartmentService departmentService;

//    @RequestMapping("/")
//    public ModelAndView doHome(){
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("department", departmentRepo.findAll());
////        mv.addObject("totalItems", )
//        return mv;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView doSearch(@ModelAttribute("departmentModel") DepartmentDto departmentDto, Pageable pageable, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("index");
        //try {
            // check status delete
            Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
            if (inputFlashMap != null) {
                String statusDel = (String) inputFlashMap.get("statusDel");
                // TODO: convert to switch case
                if (statusDel.equals("0")) {
                    mv.addObject("msgDel", "xóa thành công ");
                } else if (statusDel.equals("1")) {
                    mv.addObject("msgDel", "không thể xóa phòng ban này, vui lòng xóa nhân viên trước");
                } else if (statusDel.equals("2")) {
                    mv.addObject("msgDel","error");
                }
            }
            DepartmentMapDto result = departmentService.search(departmentDto,pageable);
            mv.addObject("department",result.getList());
            mv.addObject("totalItems", result.getNumberOfItems());
            return mv;
//        }catch (Exception ex){
//            return null;
//        }
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("depart_name") String depart_name,
                               @RequestParam("Description") String description){
        ModelAndView mv = new ModelAndView("redirect:/");
        Department department = new Department();
        department.setDepartName(depart_name);
        department.setDescription(description);
        departmentRepo.save(department);
        return mv;
    }



    @RequestMapping(value = "/view/{departId}",method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("departId") int departId){
        ModelAndView mv = new ModelAndView("view");
//        Optional<Department> obj = departmentRepo.findById(departId);
        mv.addObject("department", departmentRepo.findById(departId).get());

        return mv;
    }

    @RequestMapping(value = "/delete/{departId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("departId") int departId, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/");

        try {

            boolean result = departmentService.delete(departId); // luon tra ve true hoac false
            // kiem tra ket qua xoa department
            if(result) {
                // xoa thanh cong
                redirectAttributes.addFlashAttribute("statusDel", "0");
            } else  {
                // xoa that bai
                redirectAttributes.addFlashAttribute("statusDel", "1");
            }
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("statusDel", "2");
        }
        return mv;
    }

    @RequestMapping(value = "/edit/{departId}", method = RequestMethod.GET)
    public ModelAndView doUpdate(@PathVariable("departId") int departId){
        ModelAndView mv = new ModelAndView("edit");
        Optional<Department> result = departmentRepo.findById(departId);
        mv.addObject("department", departmentRepo.findById(departId).get());
        return mv;
    }

    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
    public ModelAndView doSavec(@RequestParam("depart_Id")String depart_Id,@RequestParam("depart_name") String depart_name,
                                @RequestParam("Description") String description){
        ModelAndView mv = new ModelAndView("redirect:/");

        Department department = new Department();
        department.setDepartId(Integer.parseInt(depart_Id));
        department.setDepartName(depart_name);
        department.setDescription(description);
        departmentRepo.save(department);
        return mv;
    }

}
