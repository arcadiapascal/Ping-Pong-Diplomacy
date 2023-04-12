import axios from 'axios';



export default {

    listTournaments(userId) {
        return axios.get(`/tournaments${userId}`);
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