import React, { useState, useEffect } from 'react';
import ProgressBar from 'react-bootstrap/ProgressBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

const HabitProgressBar = ({ habitData }) => {
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

    const daysInMonth = 30;

    const formatToMMDD = (date) => {
        return date?.toLocaleDateString('en-US', { month: '2-digit', day: '2-digit' });
    };

    useEffect(() => {
        fetch('http://localhost:8080/habits/all')
            .then((response) => response.json())
            .then((data) => {
                const habitDataInfo = data.map((habit) => ({
                    name: habit.name,
                    description: habit.description,
                }));
                setHabitDataInfo(habitDataInfo);
            })
            .catch((error) => {
                console.error('Error fetching habit data:', error);
            });
        setCurrentWeek(getCurrentWeek());
    }, []);

    if (!habitData || habitData.length === 0 || habitDataInfo.length === 0) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            {habitDataInfo.map((habitInfo, index) => {
                const habitDataItem = habitData[index];
                if (!Array.isArray(habitDataItem)) {
                    return null;
                }

                const totalDays = habitDataItem.length;
                const completedDays = habitDataItem.filter((day) => day).length;
                const progress = (completedDays / totalDays) * 100;

                const progressBarStyle = {
                    backgroundColor: 'black',
                };

                return (
                    <div key={index}>
                        <h1 align="left">{habitInfo.name}</h1>
                        <p align="left">{habitInfo.description}</p>
                        <ProgressBar
                            now={progress}
                            label={`${progress.toFixed(0)}%`}
                            style={progressBarStyle}
                            className="custom-progress-bar"
                        />
                        <div className="dots">
                            {habitDataItem.map((completed, dayIndex) => (
                                <span
                                    key={dayIndex}
                                    className={completed ? 'dot completed' : 'dot'}
                                >
                                    <span className="dot-text">
                                        {formatToMMDD(new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate() - currentDate.getDay() + dayIndex + 1))}
                                    </span>
                                </span>
                            ))}
                        </div>
                    </div>
                );
            })}
        </div>
    );
};

export default HabitProgressBar;