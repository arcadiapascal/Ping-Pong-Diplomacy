BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO player (username, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, photo_file, team_name)
VALUES ('player1', 'John Doe', 25, 'Dallas', 'TX', 10, 5, 0.67, 1, 500, 'R', 'john@example.com', 'player1.jpg', 1001, 'Team A'),
       ('player2', 'Jane Smith', 32, 'New York', 'NY', 8, 6, 0.57, 2, 400, 'L', 'jane@example.com', 'player2.jpg', 1002, 'Team B'),
       ('player3', 'Mike Johnson', 28, 'Los Angeles', 'CA', 12, 3, 0.80, 3, 600, 'R', 'mike@example.com', 'player3.jpg', 1003, 'Team C'),
       ('player4', 'Sarah Brown', 29, 'Chicago', 'IL', 7, 8, 0.47, 4, 300, 'L', 'sarah@example.com', 'player4.jpg', 1004, 'Team A'),
       ('player5', 'David Lee', 35, 'Miami', 'FL', 15, 2, 0.88, 5, 700, 'R', 'david@example.com', 'player5.jpg', 1005, 'Team B'),
       ('player6', 'Emily Davis', 26, 'San Francisco', 'CA', 9, 4, 0.69, 6, 450, 'L', 'emily@example.com', 'player6.jpg', 1006, 'Team C'),
       ('player7', 'James Wilson', 33, 'Houston', 'TX', 11, 6, 0.65, 7, 550, 'R', 'james@example.com', 'player7.jpg', 1007, 'Team A'),
       ('player8', 'Olivia Jackson', 27, 'Boston', 'MA', 6, 9, 0.40, 8, 250, 'L', 'olivia@example.com', 'player8.jpg', 1008, 'Team B'),
       ('player9', 'Daniel Kim', 31, 'Seattle', 'WA', 14, 3, 0.82, 9, 650, 'R', 'daniel@example.com', 'player9.jpg', 1009, 'Team C'),
       ('player10', 'Sophia Chen', 24, 'San Diego', 'CA', 5, 7, 0.42, 10, 200, 'L', 'sophia@example.com', 'player10.jpg', 1010, 'Team A');

INSERT INTO team (team_name, description, city, state_abbrev)
VALUES ('Team A', 'This is Team A', 'Dallas', 'TX'),
       ('Team B', 'This is Team B', 'New York', 'NY'),
       ('Team C', 'This is Team C', 'Los Angeles', 'CA');

INSERT INTO tournament_team (tournament_id, team_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3),
       (3, 1),
       (3, 2),
       (4, 3),
       (4, 1),
       (4, 2),
       (4, 3);

INSERT INTO player_team (player_id, team_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2),
       (5, 3),
       (6, 3),
       (7, 3),
       (8, 3),
       (9, 1),
       (10, 2);

INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, skill_level, active, registration_deadline)
VALUES ('Tournament 1', 'Description 1', 20, '2023-05-01 09:00:00', '1234 Elm Street, Springfield, IL', 'Novice', true, '2023-04-15'),
       ('Tournament 2', 'Description 2', 15, '2023-05-10 14:30:00', '5678 Oak Avenue, Chicago, IL', 'Intermediate', true, '2023-04-25'),
       ('Tournament 3', 'Description 3', 10, '2023-06-05 18:00:00', '9876 Maple Drive, Peoria, IL', 'Advanced', true, '2023-05-20');

INSERT INTO host (host_name, username)
VALUES ('Host 1', 'host1_username'),
       ('Host 2', 'host2_username'),
       ('Host 3', 'host3_username');
-- Populating data for tournament_host table
INSERT INTO tournament_host (tournament_id, host_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);
-- Populating data for users table
INSERT INTO users (username, password_hash, role)
VALUES ('user1', 'password_hash_1', 'player'),
       ('user2', 'password_hash_2', 'player'),
       ('user3', 'password_hash_3', 'player'),
       ('host1', 'password_hash_4', 'host'),
       ('host2', 'password_hash_5', 'host'),
       ('host3', 'password_hash_6', 'host');
-- Populating data for tournament_player table
INSERT INTO tournament_player (tournament_id, player_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6);

COMMIT TRANSACTION;
