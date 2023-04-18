import axios from 'axios';



export default {

    addPlayerToTournament(id, player) {
        return axios.post(`/tournaments/${id}/players`, player);
      },

    getPlayerObject(id, player){
        return axios.get('/players/id/{id}', player)
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

    create(tournament) {
        return axios.post(`/tournaments/create`, tournament);
    },

    update(id, tournament) {
        return axios.put(`/tournaments/${id}`, tournament);
    },

    delete(id) {
        return axios.delete(`/tournaments/${id}`);
    }


}