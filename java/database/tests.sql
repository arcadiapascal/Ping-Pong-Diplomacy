select *
from users

select *
from player

select *
from team

select *
from host

select *
from tournament

select *
from tournament_player

DELETE FROM tournament WHERE tournament_id = 9

INSERT INTO tournament (tournament_name, tournament_description, player_count, tournament_date, tournament_address, location, skill_level, active, registration_deadline)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)