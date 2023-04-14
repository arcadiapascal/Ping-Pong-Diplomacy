select *
from users

select *
from player
join users on player.user_id = users.user_id

select *
from team

select *
from team
join player_team on team.team_id = player_team.team_id
join player on player_team.player_id = player.player_id

select *
from host
join users on host.user_id = users.user_id

select *
from tournament

select tournament.tournament_id, tournament.tournament_name, player.player_id, player.player_name
from tournament
join tournament_player on tournament.tournament_id = tournament_player.tournament_id
join player on tournament_player.player_id = player.player_id

select *
from tournament_player