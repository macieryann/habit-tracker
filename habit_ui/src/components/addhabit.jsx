import React, { useState } from 'react';
import { Dialog, DialogContent, DialogTitle, TextField } from '@mui/material';

function AddHabit() {
  const [addVisible, setAddVisible] = useState(false);
  const [newHabit, setNewHabit] = useState({ name: '', description: '', startDate: '', endDate: '' });

  const openAddDialog = () => {
    setNewHabit({ name: '', description: '' });
    setAddVisible(true);
  };

  const closeAddDialog = () => {
    setAddVisible(false);
  };

  const handleInputChange = (e) => {
    const { id, value } = e.target;
    setNewHabit((prevHabit) => ({
      ...prevHabit,
      [id]: value,
    }));
  };

  const onAddHabit = async (habitData) => {
    try {
      const response = await fetch('http://localhost:8080/habits/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(habitData),
      });

      if (response.ok) {
        console.log('Habit created successfully');
        closeAddDialog();
      } else {
        console.error('Failed to create habit');
      }
    } catch (error) {
      console.error('Error creating habit:', error);
    }
  };

  return (
    <div>
      <button variant="contained" onClick={openAddDialog}>
        Add New Habit
      </button>
      <Dialog open={addVisible} onClose={closeAddDialog}>
        <DialogTitle>Add New Habit</DialogTitle>
        <DialogContent>
          <TextField
            margin="dense"
            fullWidth
            id="name"
            label="Name"
            type="text"
            value={newHabit.name}
            onChange={handleInputChange}
          />
          <TextField
            margin="dense"
            fullWidth
            id="description"
            label="Description"
            type="text"
            value={newHabit.description}
            onChange={handleInputChange}
          />
          <div className="edit-buttons">
            <button variant="contained" color="primary" onClick={() => onAddHabit(newHabit)}>Add</button>
            <button variant="contained" color="default" onClick={closeAddDialog}>Cancel</button>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}

export default AddHabit;