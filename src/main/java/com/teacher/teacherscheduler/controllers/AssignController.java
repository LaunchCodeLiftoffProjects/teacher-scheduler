package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.AssignDao;
import com.teacher.teacherscheduler.data.StudentDao;
import com.teacher.teacherscheduler.data.TeacherDao;

import com.teacher.teacherscheduler.models.Assign;
import com.teacher.teacherscheduler.models.Student;
import com.teacher.teacherscheduler.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("assign")
public class AssignController {

    @Autowired
    private AssignDao assignDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

//    @Autowired
//    private CourseDao courseDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", " create Assign");
        model.addAttribute("assigns", assignDao.findAll());
        return "assign/view";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddform(Model model) {
        model.addAttribute("title", "Add Assign");

        model.addAttribute(new Assign());
        model.addAttribute("teachers", teacherDao.findAll());
        model.addAttribute("students", studentDao.findAll());
//        model.addAttribute("courses", courseDao.findAll());
        return "assign/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid Assign assign,
                                 Errors errors, @RequestParam int teacherId, @RequestParam int studentId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Assign");

//            model.addAttribute("assigns",assignDao.findAll());
            model.addAttribute("teachers", teacherDao.findAll());
            model.addAttribute("students", studentDao.findAll());
//            model.addAttribute("courses", courseDao.findAll());

            return "assign/add";
        }
        Teacher teacher = teacherDao.findOne(teacherId);
        Student student = studentDao.findOne(studentId);
//        Course course = courseDao.findOne(courseId);
        assign.setTeacher(teacher);
        assign.setStudent(student);
//        assign.setCourse(course);
        assignDao.save(assign);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveAssignForm(Model model) {
        model.addAttribute("title", "Remove ");
        model.addAttribute("assigns", assignDao.findAll());
        return "assign/remove";

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveAssignForm(@RequestParam int[] assignIds) {
        for (int assignId : assignIds) {
            assignDao.delete(assignId);
        }
        return "redirect:";

    }


    @RequestMapping(value = "update/{assignId}", method = RequestMethod.GET)
    public String displayUpdateAssignForm(Model model, @PathVariable int assignId) {
        model.addAttribute("title", "Update Assign");

        model.addAttribute("assign", assignDao.findOne(assignId));
        model.addAttribute("assigns", assignDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());
        model.addAttribute("students", studentDao.findAll());
        //            model.addAttribute("courses", courseDao.findAll());
        return "assign/update";

    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String processUpdateAssignForm(@RequestParam String period, @RequestParam int teacherId,
                                          @RequestParam int studentId, @RequestParam int assignId) {

        Assign assign = assignDao.findOne(assignId);
        Teacher teacher = teacherDao.findOne(teacherId);
        Student student = studentDao.findOne(studentId);
        //Course course = courseDao.findone(courseId);
        assign.setPeriod(period);
        assign.setTeacher(teacher);
//        assign.setCourse(course);
        assign.setStudent(student);


        assignDao.save(assign);
        return "redirect:";
        //model.addAttribute("assign",assign);

    }
}