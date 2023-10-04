import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

export default function Header() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar>
        <Toolbar>
          <Typography textAlign={'left'} variant="h6" sx={{ flexGrow: 1 }}>
            HabitHub
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
}