package com.github.macieryann.service;

import com.github.macieryann.common.StatusCode;
import com.github.macieryann.dao.HabitsDao;
import com.github.macieryann.entity.HabitsEntity;
import com.github.macieryann.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class HabitsService extends CrudService<HabitsEntity, Long> {
    private final HabitsDao habitsDao;

    @Autowired
    public HabitsService(HabitsDao habitsDao) {
        super(habitsDao);
        this.habitsDao = habitsDao;
    }

    @Override
    public void updateFields(HabitsEntity requestEntity, HabitsEntity fetchedEntity) {
        // habitId, name, description, datetimeModified
        fetchedEntity.setHabitId(requestEntity.getHabitId());
        fetchedEntity.setName(requestEntity.getName());
        fetchedEntity.setDescription(requestEntity.getDescription());
        fetchedEntity.setDatetimeModified(requestEntity.getDatetimeModified());
//        fetchedEntity.setHabitStartDate(requestEntity.getHabitStartDate());
//        fetchedEntity.setHabitEndDate(requestEntity.getHabitEndDate());
    }

    public List<HabitsEntity> retrieveAllHabits() {
        return habitsDao.findAll();
    }

    public HabitsEntity retrieveHabitById(Long habitId) {
        return habitsDao.retrieveHabitById(habitId);
    }

    public HabitsEntity saveHabit(HabitsEntity habit) {
        Long maxHabitId = habitsDao.findMaxHabitId();
        if (maxHabitId == null) {
            maxHabitId = 0L;
        }
        habit.setHabitId(maxHabitId + 1);
        habit.setDatetimeModified(Instant.now());

        return habitsDao.save(habit);
    }

    public StatusCode editHabit(HabitsEntity habit) {
        Long habitId = habit.getHabitId();
        habit.setDescription(habit.getDescription());
        habit.setName(habit.getName());
        habit.setDatetimeModified(Instant.now());
        return super.editEntity(habitId, habit);
    }

    public String deleteHabit(Long habitId) {
        habitsDao.deleteById(habitId);
        return "habit deleted! :(";
    }

}
