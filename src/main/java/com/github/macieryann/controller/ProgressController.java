package com.github.macieryann.controller;

import com.github.macieryann.common.StatusCode;
import com.github.macieryann.entity.ProgressEntity;
import com.github.macieryann.service.ProgressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/habit-progress")
@Tag(name = "progress controller")
public class ProgressController {
    private final ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/all")
    public List<ProgressEntity> allProgress() {
        return progressService.retrieveAllProgress();
    }

    @GetMapping("/info/{habitId}")
    public List<ProgressEntity> retrieveProgressByHabitId(@PathVariable Long habitId) {
        return progressService.retrieveHabitById(habitId);
    }

    @PostMapping("/add-progress")
    public ProgressEntity insertHabitProgress(@RequestBody ProgressEntity progress){
        return progressService.saveProgress(progress);
    }

    @PostMapping("/edit-progress")
    public StatusCode editProgress(@RequestBody ProgressEntity progress) {
        return progressService.editProgress(progress);
    }

    @GetMapping("/delete/{progressId}")
    public StatusCode deleteProgressByProgressID(@PathVariable Long progressId) {
        return progressService.deleteProgressByProgressId(progressId);
    }

//    @GetMapping("/delete/{habitId}")
//    public String deleteProgressByHabitID(@PathVariable Long habitId) {
//        return null;
//    }
}
