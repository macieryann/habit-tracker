import React from 'react';
import '../App.css';

const TodaysDate = () => {
    // Get the current date
    const currentDate = new Date();
  
    // Format the date as "Month Day, Year"
    const formattedDate = currentDate.toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
    });
  
    return (
      <div>
        <h2>{formattedDate}</h2>
      </div>
    );
  };
  

export default TodaysDate;