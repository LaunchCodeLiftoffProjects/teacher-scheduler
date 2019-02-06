package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.StudentDao;
import com.teacher.teacherscheduler.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentDao studentDao; // Data Access Object  --we will send the data from database by creating Autowired.


    @RequestMapping(value ="")
    public String index(Model model) {
        //model.addAttribute("title", "Create Student");
        model.addAttribute("students", studentDao.findAll());
        model.addAttribute("title", "Create Student");
        return "student/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddStudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute(new Student());
        model.addAttribute("students", studentDao.findAll());
        return "student/add";

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddStudentForm(@ModelAttribute @Valid Student newStudent,
                                        Errors errors,
                                        Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Student");
            model.addAttribute("students", studentDao.findAll());
            return "student/add";
        }
//        Student stu = studentDao.findOne(studentId);
//        newStudent.setStudent(stu);

        studentDao.save(newStudent);
        return "redirect:";
    }
    @RequestMapping(value= "edit/{id}", method = RequestMethod.GET)
            public String displayEditform(Model model,@PathVariable int id) {
        model.addAttribute("title", "Edit Student");
        model.addAttribute("students", studentDao.findOne(id));
        return "student/edit";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String displayEditform(Model model,Student newStudent,@PathVariable int id, @RequestParam String name,@RequestParam String grade,@RequestParam String emailId ){
        model.addAttribute("students", studentDao.findOne(id));
       Student stu = studentDao.findOne(id);
        newStudent.setStudent(stu);
        studentDao.save(newStudent);
        return "redirect:";







}
    }
