import axios from 'axios';



export default {

    getTeams(){
        return axios.get(`/teams`);
    },

    getHosts(){
        return axios.get(`/hosts`);
    },

    getPlayers(){
        return axios.get(`/players`);
    },

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
    }

    



}