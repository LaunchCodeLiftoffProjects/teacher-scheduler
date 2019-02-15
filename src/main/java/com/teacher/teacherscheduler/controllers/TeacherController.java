package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.StudentDao;
import com.teacher.teacherscheduler.data.TeacherDao;
import com.teacher.teacherscheduler.models.Student;
import com.teacher.teacherscheduler.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

@Controller
@RequestMapping("teacher")
public class TeacherController {


    @Autowired
    private TeacherDao teacherDao; // Data Access Object  --we will send the data from database by creating Autowired.


    @RequestMapping(value = "")
    public String index(Model model) {
        //model.addAttribute("title", "Create Teacher");
        model.addAttribute("teachers", teacherDao.findAll());
        model.addAttribute("title", "Create Teacher");
        return "teacher/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTeacherForm(Model model) {
        model.addAttribute("title", "Add Teacher");
        model.addAttribute(new Teacher());
        model.addAttribute("teachers", teacherDao.findAll());
        return "teacher/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTeacherForm(@ModelAttribute @Valid Teacher newTeacher,
                                        Errors errors,
                                        Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Teacher");
            model.addAttribute("teachers", teacherDao.findAll());
            return "teacher/add";
        }


        teacherDao.save(newTeacher);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTeacherForm(Model model) {
        model.addAttribute("title", "Remove Teacher");
        model.addAttribute("teachers", teacherDao.findAll());
        return "teacher/remove";

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTeacherForm(@RequestParam int[] teacherIds) {
       for (int teacherId : teacherIds){
           teacherDao.delete(teacherId);
       }
       return "redirect:";

    }


    @RequestMapping(value = "update/{teacherId}", method = RequestMethod.GET)
    public String displayUpdateTeacherForm(Model model,@PathVariable int teacherId) {
        model.addAttribute("title", "Update Teacher");

        model.addAttribute("teacher",teacherDao.findOne(teacherId)) ;
         model.addAttribute("teachers", teacherDao.findAll());
        return "teacher/update";

    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String processUpdateTeacherForm(@RequestParam String name, @RequestParam String emailId,
                                           @RequestParam int teacherId) {

        Teacher teacher = teacherDao.findOne(teacherId);
        teacher.setName(name);
        teacher.setEmailId(emailId);


        teacherDao.save(teacher);
        return "redirect:";
    }
}