BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username, password_hash, role)
VALUES ('alice', 'hashed_password1', 'player'),
('bob', 'hashed_password2', 'player'),
('charlie', 'hashed_password3', 'host'),
('david', 'hashed_password4', 'host');

INSERT INTO player (userid, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, photo_file, team_name)
VALUES (1, 'Alice Smith', 25, 'Los Angeles', 'CA', 10, 2, 0.83, 1, 1000, 'R', 'alice@example.com', 'alice.jpg', 'Team A'),
(2, 'Bob Johnson', 30, 'New York', 'NY', 8, 4, 0.67, 2, 800, 'L', 'bob@example.com', 'bob.jpg', 'Team B');

INSERT INTO team (team_name, description, city, state_abbrev)
VALUES ('Team A', 'A great team', 'Los Angeles', 'CA'),
('Team B', 'A solid team', 'New York', 'NY'),
('Team C', 'A new team', 'Chicago', 'IL');

INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline)
VALUES ('Tournament 1', 'The first tournament', 16, '2023-05-01 10:00:00', '123 Main St', 'New York', 'Intermediate', true, '2023-04-15'),
('Tournament 2', 'The second tournament', 32, '2023-06-01 12:00:00', '456 Elm St', 'Los Angeles', 'Advanced', true, '2023-05-15');

INSERT INTO host (host_name, userid)
VALUES ('Charlie Brown', 3),
('David Green', 4);

INSERT INTO tournament_host (tournament_id, host_id)
VALUES (1, 3),
(2, 4);

INSERT INTO tournament_player (tournament_id, player_id)
VALUES (1, 1),
(1, 2),
(2, 1),
(2, 2);

INSERT INTO player_team (player_id, team_id)
VALUES (1, 1),
(2, 2);

INSERT INTO tournament_team (tournament_id, team_id)
VALUES (1, 1),
(1, 2),
(2, 2),
(2, 3);

COMMIT TRANSACTION;
