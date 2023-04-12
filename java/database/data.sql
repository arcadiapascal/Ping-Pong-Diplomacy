BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Insert users
INSERT INTO users (username, password_hash, role) VALUES
('alice', 'password123', 'player'),
('bob', 'qwerty', 'player'),
('charlie', 'letmein', 'host'),
('dave', 'hunter2', 'host');

-- Insert players
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name) VALUES
(1, 'Alice Smith', 25, 'San Francisco', 'CA', 10, 5, 0.67, 1, 100, 'R', 'alice@example.com', NULL),
(2, 'Bob Johnson', 30, 'Los Angeles', 'CA', 8, 7, 0.53, 2, 80, 'L', 'bob@example.com', NULL);

-- Insert teams
INSERT INTO team (team_name, description, city, state_abbrev) VALUES
('Team A', 'Our team is the best!', 'San Francisco', 'CA'),
('Team B', 'We play to win!', 'Los Angeles', 'CA');

-- Insert hosts
INSERT INTO host (host_name, user_id) VALUES
('Charlie Brown', 3),
('Dave Davis', 4);

-- Insert tournaments
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline) VALUES
('Summer Open', 'Our annual summer tournament', 32, '2023-06-01 09:00:00', '123 Main St', 'San Francisco', 'Intermediate', true, '2023-05-01'),
('Fall Classic', 'Our fall tournament for advanced players', 16, '2023-10-01 10:00:00', '456 Maple St', 'Los Angeles', 'Advanced', false, '2023-09-01');

-- Insert tournament_team
INSERT INTO tournament_team (tournament_id, team_id) VALUES
(1, 1),
(1, 2),
(2, 1);

-- Insert player_team
INSERT INTO player_team (player_id, team_id) VALUES
(1, 1),
(2, 2);

-- Insert tournament_host
INSERT INTO tournament_host (tournament_id, host_id) VALUES
(1, 3),
(2, 4);

-- Insert tournament_player
INSERT INTO tournament_player (tournament_id, player_id) VALUES
(1, 1),
(1, 2),
(2, 1);

COMMIT TRANSACTION;
