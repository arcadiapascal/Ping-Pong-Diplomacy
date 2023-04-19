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

    update(id, player) {
        return axios.put(`/players/${id}`, player);
    },

    delete(id) {
        return axios.delete(`/players/${id}`);
    },
    
    getUserIdByUsername(username){
        username="corico23"
        return axios.get(`username/1/${username}`)
                           
    },
    createPlayer(player){
        return axios.post(`/players/create`,player)              
    }
}