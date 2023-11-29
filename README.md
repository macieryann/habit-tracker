# habit-tracker

<img width="1248" alt="image" src="https://github.com/macieryann/habit-tracker/assets/36053347/a6737f54-af8a-4d5f-904f-d3ee8be5e3c1">

## Refresh Page button:

window.location.reload()

On refresh (as well as opening the page) the following calls are made:

### .../habits/all
Request:

>No parameters needed

Response:
>[
  {
    "habitId": 0,   
    "name": "string",    
    "description": "string",    
    "datetimeModified": "2023-11-29T22:00:08.493Z"  
  }
]

### .../habit-progress/info/{habit-id}
Request:

>path variable (Long): habit-id

Response:
>[
  {
    "progressId": 0,
    "habit": {
      "habitId": 0,
      "name": "string",
      "description": "string",
      "datetimeModified": "2023-11-29T22:03:45.242Z"
    },
    "datetimeModified": "2023-11-29T22:03:45.242Z",
    "completed": true,
    "habitDate": "2023-11-29"
  }
]

## Add Habit button:
.../habits/create
The UI takes a habit name string and habit description Strings and calls /habits/create.  The backend finds the max existing habit ID from the database and adds 1 and also sets date&time modified field to current timestamp.

>{
  "habitId": 0,
  "name": "string",
  "description": "string",
  "datetimeModified": "2023-11-29T21:53:40.749Z"
}

