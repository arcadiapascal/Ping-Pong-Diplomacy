BEGIN TRANSACTION;

DROP TABLE IF EXISTS player,tournament,team,host,tournament_player,player_team,tournament_host,tournament_team,users CASCADE;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE player
(
    player_id serial NOT NULL,
    user_id int NOT NULL,
    player_name varchar(64) NOT NULL,
    age INT CHECK (age < 110),
    city varchar(30) NOT NULL,
    state_abbrev char(2) NOT NULL,
    wins int,
    losses int,
    win_percentage numeric(3,2),
    ranking int,
    total_points int,
    right_left_handed varchar(3) CHECK (right_left_handed IN ('R', 'L')),
    email varchar(64) NOT NULL,
    photo_file varchar (255),
    photo OID,
    team_name varchar(64),

   CONSTRAINT PK_player PRIMARY KEY(player_id),
   CONSTRAINT chk_state_abbrev CHECK (state_abbrev IN ('AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'))
);


CREATE TABLE team
(
    team_id serial NOT NULL,
    team_name varchar(64) NOT NULL, 
    description varchar(255),
    city varchar(30) NOT NULL,
    state_abbrev char(2) NOT NULL,

    CONSTRAINT PK_team PRIMARY KEY(team_id),
    CONSTRAINT chk_state_abbrev CHECK (state_abbrev IN ('AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'))


);

CREATE TABLE host (
    host_id serial,
    host_name varchar(64) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_host PRIMARY KEY(host_id)
);

CREATE TABLE tournament (
    tournament_id serial NOT NULL,
    tournament_name varchar(64) NOT NULL,
    tournament_description varchar(255) NOT NULL,
    player_count int,
    tournament_date timestamp NOT NULL,
    tournament_address varchar(64) NOT NULL,
	location varchar(64) NOT NULL, 
    skill_level varchar(64) NOT NULL,
    active boolean NOT NULL,
    registration_deadline date NOT NULL,
    CONSTRAINT chk_skill_level CHECK (skill_level in ('Novice','Intermediate','Advanced')),
    CONSTRAINT PK_tournament PRIMARY KEY (tournament_id)
);

CREATE TABLE tournament_team
(
    tournament_id int NOT NULL,
    team_id int NOT NULL,

   CONSTRAINT PK_tournament_team PRIMARY KEY (tournament_id, team_id)
);

CREATE TABLE player_team
(
    player_id int NOT NULL,
    team_id int NOT NULL,

    CONSTRAINT PK_player_team PRIMARY KEY (player_id, team_id)
);
 
CREATE TABLE tournament_host (
    tournament_id INT,
    host_id INT,
   CONSTRAINT PK_tournament_host PRIMARY KEY (tournament_id, host_id)
);    

CREATE TABLE tournament_player(
	tournament_id INT,
	player_id INT, 
	 constraint PK_tournament_player PRIMARY KEY (tournament_id, player_id)

);


ALTER TABLE player_team
ADD CONSTRAINT FK_player_team FOREIGN KEY (player_id) REFERENCES player(player_id),
ADD CONSTRAINT FK_team_player FOREIGN KEY (team_id) REFERENCES team(team_id);

ALTER TABLE tournament_player
ADD CONSTRAINT FK_tournament_player FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id),
ADD CONSTRAINT FK_player_tournament FOREIGN KEY (player_id) REFERENCES player(player_id);

ALTER TABLE tournament_host
ADD CONSTRAINT FK_tournament_host FOREIGN KEY (tournament_id) REFERENCES tournament(tournament_id),
ADD CONSTRAINT FK_host_tournament FOREIGN KEY (host_id) REFERENCES host(host_id);

ALTER TABLE player
ADD CONSTRAINT FK_userid_player FOREIGN KEY (user_id) REFERENCES users(user_id);


ALTER TABLE host 
ADD CONSTRAINT FK_userid_host FOREIGN KEY (user_id) REFERENCES users(user_id);
 
  
COMMIT;
-- ROLLBACK
