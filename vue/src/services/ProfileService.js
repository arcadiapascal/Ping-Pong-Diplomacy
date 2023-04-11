import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getProfile(id) {
        return http.get(`/profiles/${id}`);
    },

    listProfiles() {
        return http.get(`/profiles`);
    },

    



}