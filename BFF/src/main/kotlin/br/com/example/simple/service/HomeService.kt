package br.com.example.simple.service

import br.com.example.simple.screen.HomeScreen
import br.com.example.simple.screen.LoginScreen
import org.springframework.stereotype.Service

@Service
class HomeService {

    fun getHomeScreen() = HomeScreen

}