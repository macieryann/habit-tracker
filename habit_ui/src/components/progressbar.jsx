import React, { useState, useEffect } from 'react';
import ProgressBar from 'react-bootstrap/ProgressBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

const HabitProgressBar = ({ habitData }) => {
    const [habitDataInfo, setHabitDataInfo] = useState([]);

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
                        <h1>{habitInfo.name}</h1>
                        <p>{habitInfo.description}</p>
                        <ProgressBar
                            now={progress}
                            label={`${progress.toFixed(2)}%`}
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
                                        {completed ? `10/${dayIndex + 1}` : ''}
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