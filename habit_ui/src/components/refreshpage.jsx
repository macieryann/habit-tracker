import React from 'react';

const RefreshPage = () => {
  const refreshPage = () => {
    window.location.reload();
  };

  return (
    <button className="header-button" onClick={refreshPage}>Refresh Page</button>
  );
};

export default RefreshPage;