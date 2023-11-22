package com.github.macieryann.service;

import com.github.macieryann.common.StatusCode;
import com.github.macieryann.dao.ProgressDao;
import com.github.macieryann.entity.ProgressEntity;
import com.github.macieryann.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProgressService extends CrudService<ProgressEntity, Long> {
    private final ProgressDao dao;

    @Autowired
    public ProgressService(ProgressDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void updateFields(ProgressEntity requestEntity, ProgressEntity fetchedEntity) {
        // progress_id, habit_id, datetime_modified, completed, habit_date
        fetchedEntity.setProgressId(requestEntity.getProgressId());
        fetchedEntity.setHabit(requestEntity.getHabit());
        fetchedEntity.setDatetimeModified(requestEntity.getDatetimeModified());
        fetchedEntity.setCompleted(requestEntity.getCompleted());
        fetchedEntity.setHabitDate(requestEntity.getHabitDate());
    }

    public List<ProgressEntity> retrieveAllProgress() {
        return dao.findAll();
    }

    public List<ProgressEntity> retrieveHabitById(Long habitId) {
        return dao.retrieveProgressByHabitId(habitId);
    }

    public ProgressEntity saveProgress(ProgressEntity progress) {
        Long maxProgressId = dao.findMaxProgressId();
        if (maxProgressId == null) {
            maxProgressId = 0L;
        }
        progress.setProgressId(maxProgressId + 1);
        progress.setDatetimeModified(Instant.now());
        progress.setHabitDate(LocalDate.now());
        return dao.save(progress);
    }

    public StatusCode editProgress(ProgressEntity progress) {
        Long progressId = progress.getProgressId();
//        progress.setHabit();
        progress.setDatetimeModified(Instant.now());
        progress.setCompleted(progress.getCompleted());
        progress.setHabitDate(LocalDate.now());
        return super.editEntity(progressId, progress);
    }

    public StatusCode deleteProgressByProgressId(Long progressId) {
        return super.deleteByIdWithStatus(progressId);
    }

}
