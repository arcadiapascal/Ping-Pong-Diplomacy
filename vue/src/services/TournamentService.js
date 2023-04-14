import axios from 'axios';



export default {

    getTeams(){
        return axios.get(`/teams`);
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