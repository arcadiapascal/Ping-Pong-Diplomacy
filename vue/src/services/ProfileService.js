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
    },
    
    getUserIdByUsername(username){
        username
        return axios.get(`/users/username/{username}/id`)
    }

    



}