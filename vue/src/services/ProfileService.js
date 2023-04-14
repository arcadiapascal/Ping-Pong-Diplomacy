import axios from 'axios';



export default {

    getProfile(id) {
        return axios.get(`/profiles/${id}`);
    },

    listProfiles() {
        return axios.get(`/profiles`);
    },

    update(id, profile) {
        return axios.put(`/profiles/${id}`, profile);
    },

    delete(id) {
        return axios.delete(`/profiles/${id}`);
    },
    getUserIdByUsername(userName){
        return axios.get(`/profiles/${userName}`)
    }

    



}