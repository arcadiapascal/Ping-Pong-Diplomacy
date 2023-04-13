import axios from 'axios';



export default {

    getProfile(id) {
        return axios.get(`/players/${id}`);
    },

    listProfiles() {
        return axios.get(`/players`);
    },

    update(id, profile) {
        return axios.put(`/players/${id}`, profile);
    },

    delete(id) {
        return axios.delete(`/players/${id}`);
    }

    



}