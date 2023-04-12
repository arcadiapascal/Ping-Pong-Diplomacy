import axios from 'axios';



export default {

    getProfile(id) {
        return axios.get(`/profiles/${id}`);
    },

    listProfiles() {
        return axios.get(`/profiles`);
    },

    update(id, profile) {
        return http.put(`/profiles/${id}`, profile);
    },

    delete(id) {
        return http.delete(`/profiles/${id}`);
    }

    



}