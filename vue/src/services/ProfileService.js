import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    get(id) {
        return http.get(`/profiles/${id}`);
    },

    list() {
        return http.get(`/profiles`);
    },

    update(id, profile) {
        return http.put(`/profiles/${id}`, profile);
    },

    delete(id) {
        return http.delete(`/profiles/${id}`);
    }

    



}