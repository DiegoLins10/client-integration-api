package com.github.diegolins10.clientapi.api.dto;

public record CreateClientResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado
) {}
