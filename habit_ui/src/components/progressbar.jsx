import React, { useState, useEffect } from 'react';
import ProgressBar from 'react-bootstrap/ProgressBar';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';
import Divider from '@mui/material/Divider';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

const ColorButton = styled(Button)(() => ({
    backgroundColor: '#605DC8',
    '&:hover': {
        backgroundColor: '#605DC8',
    },
}));

const HabitProgressBar = () => {
    const [habitDataInfo, setHabitDataInfo] = useState([]);
    const [currentWeek, setCurrentWeek] = useState({ start: null, end: null });
    const currentDate = new Date();

    const getCurrentWeek = () => {
        const currentDate = new Date();
        const currentDay = currentDate.getDay();
        const diff = currentDay - 1;
        currentDate.setDate(currentDate.getDate() - diff);

        const startOfWeek = new Date(currentDate);
        const endOfWeek = new Date(currentDate);

        endOfWeek.setDate(endOfWeek.getDate() + 6);

        return { start: startOfWeek, end: endOfWeek };
    }

    const formatToMMDD = (date) => {
        return date?.toLocaleDateString('en-US', { month: '2-digit', day: '2-digit' });
    };

    useEffect(() => {
        fetch('http://localhost:8080/habits/all')
            .then((response) => response.json())
            .then((habitData) => {
                setCurrentWeek(getCurrentWeek());
                setHabitDataInfo(habitData);

                // fetch progress data for each habit
                const progressPromises = habitData.map((habit) =>
                    fetch(`http://localhost:8080/habit-progress/info/${habit.habitId}`)
                        .then((response) => response.json())
                        .then((progressData) => ({ ...habit, progressData }))
                );

                Promise.all(progressPromises)
                    .then((habitsWithProgress) => {
                        setHabitDataInfo(habitsWithProgress);
                    })
                    .catch((error) => {
                        console.error('Error fetching habit progress data:', error);
                    });
            })
            .catch((error) => {
                console.error('Error fetching habit data:', error);
            });
    }, []);

    if (!habitDataInfo || habitDataInfo.length === 0) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            {habitDataInfo.map((habitInfo, index) => {
                const totalDays = 7;
                const completedDays = habitInfo.progressData?.filter((progress) => progress.completed).length || 0;
                const progress = (completedDays / totalDays) * 100;

                const progressBarStyle = {
                    backgroundColor: '#999999',
                    height: '40px'
                };

                return (
                    <div>
                        <div key={index} className="habit-list-item">
                            <div>
                                <Stack spacing={2} direction="row">
                                    <h1 align="left">{habitInfo.name}</h1>
                                    <ColorButton size="small" variant="contained">Completed?</ColorButton>
                                </Stack>
                            </div>
                            <p align="left">{habitInfo.description}</p>
                            <ProgressBar
                                now={progress}
                                label={`${progress.toFixed(0)}%`}
                                style={progressBarStyle}
                                className="custom-progress-bar"
                            />
                            <div className="dots">
                                {Array.from({ length: totalDays }, (_, dayIndex) => (
                                    <span
                                        key={dayIndex}
                                        className={habitInfo.progressData?.[dayIndex]?.completed ? 'dot completed' : 'dot'}
                                    >
                                        <span className="dot-text">
                                            {formatToMMDD(new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate() - currentDate.getDay() + dayIndex + 1))}
                                        </span>
                                    </span>
                                ))}
                            </div>
                        </div>
                        <Divider sx={{ borderBottomWidth: 5 }} />
                    </div>
                );
            })}
        </div>
    );
};

export default HabitProgressBar;