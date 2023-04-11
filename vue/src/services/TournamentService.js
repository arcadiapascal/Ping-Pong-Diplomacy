import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    listTournaments() {
        return http.get(`/tournaments`);
    },

    getTournament(id) {
        return http.get(`/tournaments/${id}`);
    },

    create(tournament) {
        return http.post(`/tournaments/`, tournament);
    },

    update(id, tournament) {
        return http.put(`/tournaments/${id}`, tournament);
    },

    delete(id) {
        return http.delete(`/tournaments/${id}`);
    }


}