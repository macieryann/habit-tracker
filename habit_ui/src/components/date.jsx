import React from 'react';
import '../App.css';

const TodaysDate = () => {
    const currentDate = new Date();
  
    // Format the date as "Month Day, Year"
    const formattedDate = currentDate.toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
    });
  
    return (
      <div>
        <h6>{formattedDate}</h6>
      </div>
    );
  };
  

export default TodaysDate;