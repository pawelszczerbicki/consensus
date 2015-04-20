package com.szczerbicki;

import com.szczerbicki.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
