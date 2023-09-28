package com.github.macieryann.service;

import com.github.macieryann.dao.HabitsDao;
import com.github.macieryann.entity.HabitsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitsService {
    private final HabitsDao habitsDao;


    @Autowired
    public HabitsService(HabitsDao habitsDao) {
        this.habitsDao = habitsDao;
    }

    public List<HabitsEntity> retrieveAllHabits() {
        return habitsDao.findAll();
    }

    public HabitsEntity saveHabit(HabitsEntity habit) {
        // Find the highest existing habitId and increment it by 1
        Long maxHabitId = habitsDao.findMaxHabitId();
        if (maxHabitId == null) {
            maxHabitId = 0L;
        }
        habit.setHabitId(maxHabitId + 1);

        return habitsDao.save(habit);
    }

    // ... other service methods ...
}
