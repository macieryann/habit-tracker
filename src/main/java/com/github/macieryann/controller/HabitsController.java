package com.github.macieryann.controller;

import com.github.macieryann.entity.HabitsEntity;
import com.github.macieryann.service.HabitsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
@Tag(name = "habits controller; first service in the project")
public class HabitsController {
    private final HabitsService habitsService;

    @Autowired
    public HabitsController(HabitsService habitsService) {
        this.habitsService = habitsService;
    }

    @GetMapping("/all")
    public List<HabitsEntity> allHabits() {
        return habitsService.retrieveAllHabits();
    }

    @PostMapping("/create")
    public HabitsEntity createHabit(@RequestBody HabitsEntity habit) {
        return habitsService.saveHabit(habit);
    }

}
