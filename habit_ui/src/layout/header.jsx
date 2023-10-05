import React, { useState, useEffect } from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import MenuItem from '@mui/material/MenuItem';

const Header = ({ }) => {
  const headerStyle = {
    backgroundColor: '#9a005d',
    width: '100%',
    height: '75px'
  };

  const menuItemStyle = {
    border: '1px solid #000',
    borderRadius: '4px',
  };

  return (
    <AppBar style={headerStyle} position="sticky">
      <Toolbar>
        <Typography textAlign={'left'} variant="h6" sx={{ flexGrow: 1 }}>
          HabitHub
        </Typography>
        <MenuItem style={menuItemStyle}>
          <Typography>New Habit</Typography>
        </MenuItem>
      </Toolbar>
    </AppBar>
  );
}

export default Header;