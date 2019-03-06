package com.teacher.teacherscheduler.controllers;




import com.teacher.teacherscheduler.data.ClassroomDao;
import com.teacher.teacherscheduler.models.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("classroom")

public class ClassroomController {

    @Autowired
    private ClassroomDao classroomDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Classroom Elements");
        model.addAttribute("Classrooms", classroomDao.findAll());
        return "classroom/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddClassroomForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute(new Classroom());
        model.addAttribute("classrooms", classroomDao.findAll());
        return "classroom/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddClassroomForm(@ModelAttribute @Valid Classroom newClassroom,
                                        Errors errors,
                                        Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Classroom");
            model.addAttribute("classrooms", classroomDao.findAll());
            return "classroom/add";
        }


        classroomDao.save(newClassroom);
        return "redirect:";
        }



    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String displayEditform(@RequestParam int id,  @RequestParam String name, @RequestParam String classPeriod1, @RequestParam String classPeriod2, @RequestParam String classPeriod3, @RequestParam String classPeriod4, @RequestParam String classPeriod5) {
        Classroom newClassroom = classroomDao.findOne(id);
        newClassroom.setClassroomName(name);
        newClassroom.setclassPeriod1(classPeriod1);
        newClassroom.setclassPeriod2(classPeriod2);
        newClassroom.setclassPeriod3(classPeriod3);
        newClassroom.setclassPeriod4(classPeriod4);
        newClassroom.setclassPeriod5(classPeriod5);


        classroomDao.save(newClassroom);
        return "redirect:";
    }

}
