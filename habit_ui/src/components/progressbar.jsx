import React from 'react';
import ProgressBar from 'react-bootstrap/ProgressBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../App.css';

const HabitProgressBar = ({ habitData, habitNames }) => {
    return (
        <div>
            {habitNames.map((habitName, index) => {
                const totalDays = habitData[index].length;
                const completedDays = habitData[index].filter((day) => day).length;
                const progress = (completedDays / totalDays) * 100;

                const progressBarStyle = {
                    backgroundColor: 'beige',
                };

                return (
                    <div key={index}>
                        <h1>{habitName}</h1>
                        <ProgressBar
                            now={progress}
                            label={`${progress.toFixed(2)}%`}
                            style={progressBarStyle}
                            className="custom-progress-bar"
                        />
                        <div className="dots">
                            {habitData[index].map((completed, dayIndex) => (
                                <span
                                    key={dayIndex}
                                    className={completed ? 'dot completed' : 'dot'}
                                ></span>
                            ))}
                        </div>
                    </div>
                );
            })}
        </div>
    );
};

export default HabitProgressBar;