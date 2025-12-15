package com.github.diegolins10.clientapi.api.dto;

public record CreateClientRequest(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String cep) {

}
