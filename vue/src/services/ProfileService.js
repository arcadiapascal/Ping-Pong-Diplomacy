import axios from 'axios';



export default {

    getProfile(id) {
        return axios.get(`/profiles/${id}`);
    },

    listProfiles() {
        return axios.get(`/profiles`);
    },

    



}