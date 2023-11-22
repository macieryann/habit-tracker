package com.github.macieryann.controller;

import com.github.macieryann.common.StatusCode;
import com.github.macieryann.entity.HabitsEntity;
import com.github.macieryann.service.HabitsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/habits")
@Tag(name = "habits controller")
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

    @GetMapping("/{habitId}")
    public HabitsEntity retrieveHabitById(@PathVariable Long habitId) {
        return habitsService.retrieveHabitById(habitId);
    }

    @PostMapping("/create")
    public HabitsEntity createHabit(@RequestBody HabitsEntity habitsEntity) {
        return habitsService.saveHabit(habitsEntity);
    }

    @PostMapping("/edit")
    public StatusCode editHabit(@RequestBody HabitsEntity habitsEntity) {
        return habitsService.editHabit(habitsEntity);
    }

    @GetMapping("/delete/{habitId}")
    public String deleteHabit(@PathVariable Long habitId) {
        return habitsService.deleteHabit(habitId);
    }

}
