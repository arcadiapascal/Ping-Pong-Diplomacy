import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    list() {
        return http.get(`/tournaments`);
    },

    get(id) {
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