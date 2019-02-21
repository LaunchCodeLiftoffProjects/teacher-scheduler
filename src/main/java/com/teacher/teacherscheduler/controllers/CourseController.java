package com.teacher.teacherscheduler.controllers;
import com.teacher.teacherscheduler.data.CourseDao;
import com.teacher.teacherscheduler.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("course")
public class CourseController {


    @Autowired
    private CourseDao courseDao;


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Course Details");
        model.addAttribute("courses", courseDao.findAll());
        return "course/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCourseForm(Model model) {
        model.addAttribute("title", "Add Course");
        model.addAttribute(new Course());
        model.addAttribute("courses", courseDao.findAll());
        return "course/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCourseForm(@ModelAttribute @Valid Course newCourse,
                                        Errors errors,
                                        Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Course");
            model.addAttribute("courses", courseDao.findAll());
            return "course/add";
        }

        courseDao.save(newCourse);
        return "redirect:";

    }

    @RequestMapping(value="remove", method =RequestMethod.GET)
    public String displayRemoveCourseForm(Model model){
        model.addAttribute("courses",courseDao.findAll());
        model.addAttribute("title","Remove Course");
        return "course/remove";
    }
    @RequestMapping(value="remove",method = RequestMethod.POST)
    public String processRemoveCourseForm(@RequestParam int[] courseIds){
        for (int courseId:courseIds){
            courseDao.delete(courseId);
        }
        return "redirect:";
    }

}