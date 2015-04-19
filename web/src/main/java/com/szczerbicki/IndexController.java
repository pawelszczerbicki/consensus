package com.szczerbicki;

import com.szczerbicki.task.TaskDto;
import com.szczerbicki.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.szczerbicki.config.Keys.TASK_ADDED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by pawel on 12.04.15.
 */
@Controller
public class IndexController {

    @Autowired
    private TaskService service;

    @RequestMapping("/")
    public String welcome(Model m) {
        m.addAttribute("tasks", service.getAll());
        return "index";
    }

    @RequestMapping("/tasks/{id}")
    public String task(@PathVariable String id, Model m) {
        m.addAttribute("task", service.get(id));
        return "task";
    }

    @RequestMapping(value = "/tasks", method = POST)
    public String addTask(RedirectAttributes redirect, TaskDto t) {
        service.saveNewTask(t);
        redirect.addFlashAttribute("success", TASK_ADDED);
        return "redirect:/";
    }
}
