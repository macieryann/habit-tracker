CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE habits (
    habit_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE habit_progress (
    progress_id SERIAL PRIMARY KEY,
    habit_id INT REFERENCES habits(habit_id),
    datetime_modified TIMESTAMP NOT NULL,
    completion_status DECIMAL
);