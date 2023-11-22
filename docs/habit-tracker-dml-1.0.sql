CREATE TABLE habits (
    habit_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    datetime_modified timestamp,
    habit_start_date DATE,
    habit_end_date DATE
);

CREATE TABLE habit_progress (
    progress_id SERIAL PRIMARY KEY,
    habit_id INT REFERENCES habits(habit_id),
    datetime_modified TIMESTAMP NOT NULL,
    completed BOOLEAN,
    habit_date DATE
);

ALTER TABLE public.habits ADD habit_month int NULL;
ALTER TABLE public.habits ADD habit_year int NULL;