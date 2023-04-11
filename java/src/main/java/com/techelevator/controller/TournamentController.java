package com.techelevator.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    // POST A NEW TOURNAMENT

    // EDIT A TOURNAMENT

    // GET LIST OF ALL TOURNAMENTS

    // GET LIST OF PAST TOURNAMENTS

    // GET LIST OF PRESENT AND FUTURE TOURNAMENTS

    // GET TOURNAMENT DETAILS

}
