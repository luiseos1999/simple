package br.com.example.simple.service


import br.com.example.simple.screen.StoreScreen
import org.springframework.stereotype.Service

@Service
class StoreService {
    fun getStoreScreen() = StoreScreen
}