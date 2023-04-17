BEGIN TRANSACTION;
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Inserting some users
INSERT INTO users (username, password_hash, role) VALUES ('john_doe', 'password123', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('jane_doe', 'letmein456', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('tournament_admin', 'adminpass', 'ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('jim_smith', 'password456', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('sarah_jones', 'letmein789', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('tournament_admin_2', 'adminpass2', 'ROLE_ADMIN');

-- Inserting some players
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (1, 'User', 29, 'New York City', 'NY', 12, 4, 0.75, 7, 480, 'R', 'john_doe@gmail.com', 'Team A');
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (2, 'Admin', 26, 'Los Angeles', 'CA', 15, 3, 0.83, 2, 620, 'L', 'jane_doe@yahoo.com', 'Team B');
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (3, 'Jim', 32, 'Chicago', 'IL', 8, 5, 0.62, 15, 320, 'R', 'jim_smith@gmail.com', 'Team B');
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (4, 'Sarah', 27, 'Houston', 'TX', 10, 3, 0.77, 8, 440, 'L', 'sarah_jones@yahoo.com', 'Team C');

-- Inserting some teams
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team A', 'A competitive team', 'New York City', 'NY');
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team B', 'A fun-loving team', 'Los Angeles', 'CA');
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team C', 'A family-friendly team', 'Houston', 'TX');
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team D', 'A competitive team', 'Chicago', 'IL');

-- Inserting a host
INSERT INTO host (host_name, user_id) VALUES ('Admin Host', 2);

-- Inserting a tournament
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline) VALUES ('Big Tournament', 'The biggest tournament of the year', 64, '2023-06-01 09:00:00', '123 Main St', 'New York City', 'Advanced', true, '2023-05-01');
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline) VALUES ('Small Tournament', 'A smaller tournament', 16, '2023-08-01 10:00:00', '456 Main St', 'Los Angeles', 'Intermediate', true, '2023-07-01');
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline) VALUES ('Graduation Tournament', 'The Tech Elevator Grad Tourney', 32, '2023-04-22 10:00:00', '258 Main St', 'Cleveland', 'Novice', true, '2023-04-20');


-- Inserting tournament-player relationships
INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 1);
INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 2);
INSERT INTO tournament_player (tournament_id, player_id) VALUES (2, 3);
INSERT INTO tournament_player (tournament_id, player_id) VALUES (2, 4);

-- Inserting tournament-team relationships
INSERT INTO tournament_team (tournament_id, team_id) VALUES (1, 1);
INSERT INTO tournament_team (tournament_id, team_id) VALUES (1, 2);
INSERT INTO tournament_team (tournament_id, team_id) VALUES (2, 3);
INSERT INTO tournament_team (tournament_id, team_id) VALUES (2, 4);

-- Inserting tournament-host relationships
INSERT INTO tournament_host (tournament_id, host_id) VALUES (1, 1);
INSERT INTO tournament_host (tournament_id, host_id) VALUES (2, 1);

-- Inserting player-team relationships
INSERT INTO player_team (player_id, team_id) VALUES (1, 1);
INSERT INTO player_team (player_id, team_id) VALUES (2, 2);
INSERT INTO player_team (player_id, team_id) VALUES (3, 3);
INSERT INTO player_team (player_id, team_id) VALUES (4, 4);

COMMIT TRANSACTION;