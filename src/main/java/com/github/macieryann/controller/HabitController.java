package com.github.macieryann.controller;

import com.github.macieryann.entity.HabitEntity;
import com.github.macieryann.service.HabitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habit")
@Tag(name = "habit controller; first service in the project")
public class HabitController {
    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/create")
    public HabitEntity createHabit(@RequestBody HabitEntity habit) {
        return habitService.saveHabit(habit);
    }

}
