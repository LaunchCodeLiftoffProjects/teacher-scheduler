package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.StudentDao;
import com.teacher.teacherscheduler.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.crypto.ExemptionMechanism;
import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

import java.util.List;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Student Details");
        model.addAttribute("students", studentDao.findAll());
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
        studentDao.save(newStudent);
        return "redirect:";
        //********************EDIT************************
    }

    @RequestMapping(value = "edit/{studentId}", method = RequestMethod.GET)
    public String displayEditform(Model model, @PathVariable int studentId) {
        model.addAttribute("title", "Edit Student");
        model.addAttribute("student", studentDao.findOne(studentId));
        model.addAttribute("students", studentDao.findAll());
        return "student/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String displayEditform(@RequestParam int studentId, @RequestParam String name, @RequestParam String grade, @RequestParam String emailId) {
        Student newStudent = studentDao.findOne(studentId);
        newStudent.setName(name);
        newStudent.setGrade(grade);
        newStudent.setEmailId(emailId);
//        model.addAttribute("students", newStudent.getName());
//        model.addAttribute("students", newStudent.getGrade());
//        model.addAttribute("students", newStudent.getEmailId());
        studentDao.save(newStudent);
        return "redirect:";

    }

//    ***********************************remove****************************

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveStudentForm(Model model) {
        model.addAttribute("students", studentDao.findAll());
        model.addAttribute("title", "Remove Student");
        return "student/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveStudentForm(@RequestParam int[] studentIds) {
        for (int studentId : studentIds) {
            studentDao.delete(studentId);
        }
        return "redirect:";
    }
    //============================== search

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String displaySearchStudentForm(Model model,@ModelAttribute("name") String name) {
        model.addAttribute("title", "Search Student");

        model.addAttribute("name", name);
        model.addAttribute("students",studentDao.findAllStudentsByName(name) );
        return "student/search";
    }


//    @RequestMapping(value = "search", method = RequestMethod.POST)
//    public String displaySearchform(@RequestParam String studentId, @RequestParam String name, @RequestParam String grade, @RequestParam String emailId) {
//       Student newStudent = studentDao.findOne(name);
//
//        model.addAttribute("students", newStudent.getName());
////        model.addAttribute("students", newStudent.getGrade());
////        model.addAttribute("students", newStudent.getEmailId());
////        studentDao.save(newStudent);
//        return "redirect:";
//    }
}

