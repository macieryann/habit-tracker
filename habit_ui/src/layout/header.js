import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

export default function Header() {
  const headerStyle = {
    backgroundColor: '#9a005d',
    width: '100%',
    height: '75px'
  };

  return (
    <AppBar style={headerStyle} position="sticky">
      <Toolbar>
        <Typography textAlign={'left'} variant="h6" sx={{ flexGrow: 1 }}>
          HabitHub
        </Typography>
      </Toolbar>
    </AppBar>
  );
}