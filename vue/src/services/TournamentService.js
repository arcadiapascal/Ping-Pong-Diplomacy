import axios from 'axios';



export default {

    listTournaments() {
        return axios.get(`/tournaments`);
    },

    getTournament(id) {
        return axios.get(`/tournaments/${id}`);
    },

    create(tournament) {
        return axios.post(`/tournaments/`, tournament);
    },

    update(id, tournament) {
        return axios.put(`/tournaments/${id}`, tournament);
    },

    delete(id) {
        return axios.delete(`/tournaments/${id}`);
    }


}