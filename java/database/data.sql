BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Inserting some users
INSERT INTO users (username, password_hash, role) VALUES ('john_doe', 'password123', 'player');
INSERT INTO users (username, password_hash, role) VALUES ('jane_doe', 'letmein456', 'player');
INSERT INTO users (username, password_hash, role) VALUES ('tournament_admin', 'adminpass', 'admin');

-- Inserting some players
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (1, 'John Doe', 29, 'New York City', 'NY', 12, 4, 0.75, 7, 480, 'R', 'john_doe@gmail.com', 'Team A');
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES (2, 'Jane Doe', 26, 'Los Angeles', 'CA', 15, 3, 0.83, 2, 620, 'L', 'jane_doe@yahoo.com', 'Team B');

-- Inserting some teams
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team A', 'A competitive team', 'New York City', 'NY');
INSERT INTO team (team_name, description, city, state_abbrev) VALUES ('Team B', 'A fun-loving team', 'Los Angeles', 'CA');

-- Inserting a host
INSERT INTO host (host_name, user_id) VALUES ('Tournament Host', 3);

-- Inserting a tournament
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline) VALUES ('Big Tournament', 'The biggest tournament of the year', 32, '2023-06-01 09:00:00', '123 Main St', 'New York City', 'Advanced', true, '2023-05-01');

-- Inserting tournament-player relationships
INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 1);
INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 2);

-- Inserting tournament-team relationships
INSERT INTO tournament_team (tournament_id, team_id) VALUES (1, 1);
INSERT INTO tournament_team (tournament_id, team_id) VALUES (1, 2);

-- Inserting tournament-host relationships
INSERT INTO tournament_host (tournament_id, host_id) VALUES (1, 1);

-- Inserting player-team relationships
INSERT INTO player_team (player_id, team_id) VALUES (1, 1);
INSERT INTO player_team (player_id, team_id) VALUES (2, 2);

COMMIT TRANSACTION;
