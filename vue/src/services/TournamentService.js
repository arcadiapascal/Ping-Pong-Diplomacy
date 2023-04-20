import axios from 'axios';



export default {

    getAllPlayersFromTournament(tournamentId){
        return axios.get(`/tournaments/${tournamentId}/tournamentPlayers`)
    },

    addPlayerToTournament(id, player) {
        return axios.post(`/tournaments/${id}/players`, player);
      },

      getPlayerObject(userId, player) {
        return axios.get(`/players/id/${userId}`, player);
    },    

    getTeams(){
        return axios.get(`/teams/all`);
    },

    getHosts(){
        return axios.get(`/hosts`);
    },

    getPlayers(){
        return axios.get(`/players`);
    },

    listTournaments() {
        return axios.get(`/tournaments`);
    },

    getTournament(id) {
        return axios.get(`/tournaments/${id}`);
    },
    getPlayersInTournament(id){
        return axios.get(`/tournaments/${id}/tournamentPlayers`);
    },

    async create(tournament) {
        try {
            const response = await axios.post(`/tournaments/create`, tournament);
            console.log(response); // log the entire response object
            return response.data.tournamentId;
        } catch (error) {
            console.log(error);
        }
      },      

    update(id, tournament) {
        return axios.put(`/tournaments/${id}`, tournament);
    },

    delete(id) {
        return axios.delete(`/tournaments/${id}`);
    }


}