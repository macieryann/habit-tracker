# habit-tracker

<img width="1248" alt="image" src="https://github.com/macieryann/habit-tracker/assets/36053347/a6737f54-af8a-4d5f-904f-d3ee8be5e3c1">

# backend

## habits table

| habit_id  | name | description | datetime_modified | 
| ------------- | ------------- | ------------- | ------------- |
| 7  | read every day  | I want to read at least one chapter every day | 2023-10-06 21:47:57.897 |
| 28  | answer all emails  | I want to answer all my emails by 8pm and then log out for the night | 2023-11-22 23:44:37.050 |
| 29  | complete NYT sudoku  | I want to complete the sudoku every day to get my money's worth | 2023-11-28 22:20:57.638 |
| 30  | walk 10,000 steps every day  | I need to take 3-ish walks every day to get to 10,000 steps | 2023-11-29 21:48:19.975 |

## habit_progress table

| progress_id | habit_id | datetime_modified | completed | habit_date |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| 7 | 7 |
| 8 | 7 |
| 9 | 7 |
| 1 | 7 |
| 2 | 28 |
| 14 | 28 |
| 13 | 28 |
| 15 | 7 |
| 679 | 28 |
| 684 | 29 |
| 685 | 29 |
| 687 | 28 |
| 689 | 29 |
| 686 | 7 |
| 688 | 29 |
| 680 | 7 |
| 690 | 30 |
| 692 | 30 |
| 693 | 30 |

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

