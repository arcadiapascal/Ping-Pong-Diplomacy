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


}