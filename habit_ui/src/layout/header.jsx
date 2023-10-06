import React from 'react';
import AddHabit from '../components/addhabit';
import AppBar from '@mui/material/AppBar';
import TodaysDate from '../components/date';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import MenuItem from '@mui/material/MenuItem';

const Header = () => {
  const headerStyle = {
    backgroundColor: '#9a005d',
    width: '100%'
  };

  return (
    <AppBar style={headerStyle} sx={{ flexWrap: 1 }}>
      <Toolbar>
        <Typography textAlign={'left'} variant="h6" sx={{ flexGrow: 1 }}>
          HabitHub <TodaysDate />
        </Typography>
        <MenuItem>
          <AddHabit />
        </MenuItem>
      </Toolbar>
    </AppBar>
  );
}

export default Header;