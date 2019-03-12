package com.teacher.teacherscheduler.controllers;


import com.teacher.teacherscheduler.data.ClassroomDao;
import com.teacher.teacherscheduler.data.TeacherDao;
import com.teacher.teacherscheduler.models.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("classroom")



public class ClassroomController {

    @Autowired
    private ClassroomDao classroomDao;

    @Autowired
    private TeacherDao teacherDao;



    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Classroom Elements");
        model.addAttribute("classrooms", classroomDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());
        return "classroom/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddClassroomForm(Model model) {
        model.addAttribute("title", "Add Classroom");
        model.addAttribute(new Classroom());
        model.addAttribute("classrooms", classroomDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());
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
    @RequestMapping(value = "edit/{classroomId}", method = RequestMethod.GET)
    public String displayEditform(Model model, @PathVariable int classroomId) {
        model.addAttribute("title", "Edit Classroom");
        model.addAttribute("classroom", classroomDao.findOne(classroomId));
        model.addAttribute("classrooms", classroomDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());




        return "classroom/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String displayEditform(@RequestParam int classroomId,  @RequestParam String classroomName, @RequestParam String classPeriod1, @RequestParam String classPeriod2, @RequestParam String classPeriod3, @RequestParam String classPeriod4, @RequestParam String classPeriod5) {
        Classroom newClassroom = classroomDao.findOne(classroomId);

        newClassroom.setClassroomName(classroomName);
        newClassroom.setclassPeriod1(classPeriod1);
        newClassroom.setclassPeriod2(classPeriod2);
        newClassroom.setclassPeriod3(classPeriod3);
        newClassroom.setclassPeriod4(classPeriod4);
        newClassroom.setclassPeriod5(classPeriod5);

        classroomDao.save(newClassroom);
        return "redirect:";
    }
    @RequestMapping(value="remove", method = RequestMethod.GET)
    public String displayRemoveClassroomForm(Model model){
        model.addAttribute("classrooms",classroomDao.findAll());
        model.addAttribute("title","Remove Classroom");
        return "classroom/remove";
    }
    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String processRemoveClassroomForm(@RequestParam int[] classroomIds) {
        for (int classroomId : classroomIds) {
            classroomDao.delete(classroomId);
        }
        return "redirect:";
    }

}
