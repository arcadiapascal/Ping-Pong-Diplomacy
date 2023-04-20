import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'

import CreateTournament from '../views/CreateTournament.vue'
import HostTournament from '../views/HostTournament.vue'
import MyProfile from '../views/MyProfile.vue'
import UserProfile from '../views/UserProfile.vue'
import UserTournament from '../views/UserTournament.vue'
import Browse from '../views/Browse.vue'
import PlayerForm  from '../views/PlayerForm.vue'
import EditMyProfile from '../views/EditMyProfile.vue'
import OddTestBracket from '../views/oddTestBracket.vue'
import bracketGenerator from "../components/bracketGenerator.vue"
import ViewTournament from '../views/TournamentView.vue'


// eslint-disable-next-line no-unused-vars
// import Bracket from "../components/Bracket.vue"

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register/:id",
      name: "playerRegister",
      component: PlayerForm,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/browse",
      name: "browse",
      component: Browse,
      meta: {
        requiresAuth: false
      }
    },
   
  {
    path: "/createtournament",
    name: "createTournament",
    component: CreateTournament,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/hosttournament",
    name: "hostTournament",
    component: HostTournament,
    meta: {
      requiresAuth: true
    }
  },
  
  {
    path: "/tournament/:id",
    name: "tournament",
    component: ViewTournament,
    meta: {
      requiresAuth: true
    }
  },
  
  {
    path: "/myprofile",
    name: "myProfile",
    component: MyProfile,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/userprofile",
    name: "userProfile",
    component: UserProfile,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/editprofile",
    name: "editProfile",
    component: EditMyProfile,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/usertournament",
    name: "userTournament",
    component: UserTournament,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/testBracket",
    name: "testBracket",
    component: OddTestBracket,
  },
  {
    path: "/playgame",
    name: "playgame",
    component: bracketGenerator,
    meta: {
      requiresAuth: false
    }
  }

  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
