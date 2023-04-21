BEGIN TRANSACTION;
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Inserting some users
INSERT INTO users (username, password_hash, role)
VALUES
('randy', 'password', 'ROLE_USER'),
('feng', 'password', 'ROLE_ADMIN'),
('maggie', 'password', 'ROLE_USER'),
('rodriguez', 'password', 'ROLE_USER'),
('karate', 'password', 'ROLE_ADMIN'),
('wang', 'password', 'ROLE_ADMIN'),
('master', 'password', 'ROLE_ADMIN'),
('ForrestGump', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_ADMIN'),
('Lt. Dan Taylor', 'password', 'ROLE_ADMIN'),
('LuckyGambler23', 'password', 'ROLE_ADMIN'),
('Bob', 'password', 'ROLE_ADMIN'),
('PokerFace88', 'password', 'ROLE_ADMIN'),
('CasinoQueen27', 'password', 'ROLE_ADMIN'),
('SlotMachinePro', 'password', 'ROLE_ADMIN'),
('VegasVibes', 'password', 'ROLE_ADMIN'),
('JackpotJunkie', 'password', 'ROLE_ADMIN'),
('RouletteRider', 'password', 'ROLE_ADMIN'),
('CardShark123', 'password', 'ROLE_ADMIN');


-- Inserting some players
INSERT INTO player (user_id, player_name, age, city, state_abbrev, wins, losses, win_percentage, ranking, total_points, right_left_handed, email, team_name, photo_file)
VALUES
(3, 'Randy Daytona', 27, 'Los Angeles', 'CA', 20, 10, 0.67, 1, 750, 'R', 'randy@pingpong.com', 'Balls of Fury', 'randy.jpg'),
(4, 'Feng', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(5, 'Maggie Wong', 25, 'San Francisco', 'CA', 18, 8, 0.69, 3, 777, 'R', 'maggie@pingpong.com', 'Balls of Fury', 'maggie.jpg'),
(6, 'Carlos Rodriguez', 28, 'Mexico City', 'OH', 14, 6, 0.70, 4, 750, 'L', 'carlos@pingpong.com', 'Balls of Fury', 'carlos.jpg'),
(7, 'Freddy "Fingers" Wilson', 33, 'Brooklyn', 'NY', 10, 10, 0.50, 5, 555, 'R', 'freddy@pingpong.com', 'Balls of Fury', 'freddy.jpg'),
(8, 'The Dragon', 31, 'Hong Kong', 'NY', 12, 12, 0.50, 6, 600, 'L', 'wong@pingpong.com', 'Balls of Fury', 'wong.jpg'),
(9, 'Master Wong', 50, 'Hong Kong', 'TX', 24, 1, 1.00, 7, 500, 'R', 'master@pingpong.com', 'Balls of Fury', 'master.jpg'),
(10, 'Forrest Gump', 27, 'Greenbow', 'AL', 25, 0, 0.83, 1, 2500, 'R', 'forrestgump@example.com', 'forrest.jpg', 'Greenbow High School'),
(11, 'Lt. Dan Taylor', 25, 'Taylor', 'MS', 5, 7, 0.42, 3, 150, 'L', 'dantaylor@example.com', 'dan.jpg', 'None'),
(12, 'Bubba Blue', 26, 'Bayou La Batre', 'AL', 8, 4, 0.67, 2, 200, 'L', 'bubbablue@example.com', 'bubba.jpg', 'None'),
(13, 'Alice', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(14, 'Bob', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(15, 'Charlie', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(16, 'Diana', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(17, 'Ethan', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(18, 'Fiona', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(19, 'George', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(20, 'Hannah', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg'),
(20, 'Scott', 30, 'Beijing', 'CA', 15, 5, 0.75, 2, 600, 'L', 'feng@pingpong.com', 'Balls of Fury', 'feng.jpg');

-- Inserting some teams
INSERT INTO team (team_name, description, city, state_abbrev)
VALUES
('Team America', 'Patriotic ping pong team', 'Washington', 'VA'),
('Golden Dragons', 'Chinese ping pong team', 'Beijing', 'CA'),
('La Vida Loca', 'Mexican ping pong team', 'Mexico City', 'TX'),
('The Brooklyn Brawlers', 'Tough New York ping pong team', 'Brooklyn', 'NY'),
('Greenbow High School', 'High School Tennis Team', 'Greenbow', 'AL'),
('Crimson Tide', 'University of Alabama Tennis Team', 'Tuscaloosa', 'AL'),
('The Shrimp Boats', 'Local Bayou La Batre Tennis Club', 'Bayou La Batre', 'AL');

-- Inserting a host
INSERT INTO host (host_name, user_id)
VALUES
('feng', 4),
('randy', 3),
('master', 9),
('Forrest Gump', 10),
('Lt. Dan Taylor', 11);


-- Inserting a tournament
INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline)
VALUES
('The Emperor''s Tournament', 'A prestigious tournament held by the Emperor of the Triads.', 7, '2023-05-15 14:00:00', '1234 Imperial Way', 'Hong Kong', 'Advanced', true, '2023-05-10'),
('The Rundown Open', 'An annual tournament held in the heart of New York City.', 32, '2023-07-22 12:00:00', '56th Street & 7th Avenue', 'New York', 'Intermediate', true, '2023-07-15'),
('The Foggy Bottom Cup', 'A charity tournament to raise money for underprivileged youth in Washington D.C.', 8, '2023-09-01 10:00:00', '1600 Pennsylvania Ave NW', 'Washington D.C.', 'Novice', true, '2023-08-25'),
('The Vegas Showdown', 'A high-stakes tournament held at a famous Las Vegas casino.', 64, '2023-11-11 20:00:00', '3708 Las Vegas Blvd S', 'Las Vegas', 'Advanced', true, '2023-11-05'),
('Greenbow Invitational', 'Local high school tournament', 16, '2023-06-01 12:00:00', 'Greenbow High School Tennis Courts', 'Greenbow', 'Intermediate', true, '2023-05-25'),
('Alabama State Championships', 'Statewide tournament', 32, '2023-07-01 12:00:00', 'University of Alabama Tennis Courts', 'Tuscaloosa', 'Advanced', true, '2023-06-25');


-- Inserting tournament-player relationships
INSERT INTO tournament_player (tournament_id, player_id)
VALUES (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 2), (1, 1);

INSERT INTO tournament_player (tournament_id, player_id)
VALUES (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 2), (2, 1), (2, 9);

INSERT INTO tournament_player (tournament_id, player_id)
VALUES (3, 3), (3, 4), (3, 5), (3, 6), (3, 7), (3, 2), (3, 1), (3, 10);

INSERT INTO tournament_player (tournament_id, player_id)
VALUES (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 2), (4, 1), (4, 11), (4, 12), (4, 13), (4, 14), (4, 15), (4, 16), (4, 17), (4, 18), (4, 19);


-- Inserting some tournament-team relationships
INSERT INTO tournament_team (tournament_id, team_id)
VALUES
(1, 2), -- Golden Dragons in The Emperor's Tournament
(1, 3), -- La Vida Loca in The Emperor's Tournament
(2, 4), -- The Brooklyn Brawlers in The Rundown Open
(3, 1), -- Team America in The Foggy Bottom Cup
(4, 2); -- Golden Dragons in The Vegas Showdown

-- Inserting some tournament-host relationships
INSERT INTO tournament_host (tournament_id, host_id)
VALUES
(1, 2), -- Feng hosts The Emperor's Tournament
(2, 1), -- Randy hosts The Rundown Open
(3, 3); -- Master hosts The Foggy Bottom Cup

-- Inserting some player-team relationships
INSERT INTO player_team (player_id, team_id)
VALUES
(1, 2), -- Randy Daytona joins Golden Dragons
(2, 2), -- Feng joins Golden Dragons
(3, 3), -- Maggie Wong joins La Vida Loca
(4, 3), -- Carlos Rodriguez joins La Vida Loca
(5, 4), -- Freddy Wilson joins The Brooklyn Brawlers
(6, 1), -- Wong joins Team America
(7, 2); -- Master Wong joins Golden Dragons

COMMIT TRANSACTION;