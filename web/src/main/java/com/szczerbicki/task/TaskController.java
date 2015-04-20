package com.szczerbicki.task;

import com.szczerbicki.json.FailResponse;
import com.szczerbicki.json.JsonResponse;
import com.szczerbicki.json.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import static com.szczerbicki.utils.Keys.TASK_ADDED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by pawel on 20.04.15.
 */
@Controller
@RequestMapping("/task/")
public class TaskController {

    @Autowired
    private TaskService service;

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

    @RequestMapping(value = "/tasks/first")
    @ResponseBody
    public JsonResponse getFirstToDo() {
        Optional<Task> unfinished = service.getFirstUnfinished();
        if (!unfinished.isPresent())
            return FailResponse.create();
        return SuccessResponse.create(unfinished.get());
    }

    @RequestMapping(value = "/tasks/finish", method = POST)
    @ResponseBody
    public JsonResponse finishTask(TaskDto t) {
        service.finishTask(t);
        return SuccessResponse.create();
    }
}
