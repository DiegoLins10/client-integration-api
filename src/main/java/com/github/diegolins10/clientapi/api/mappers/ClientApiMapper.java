package com.github.diegolins10.clientapi.api.mappers;

import com.github.diegolins10.clientapi.api.dto.CreateClientResponse;
import com.github.diegolins10.clientapi.domain.entities.Client;

public class ClientApiMapper {

    private ClientApiMapper() {
        // evita instanciar
    }

    public static CreateClientResponse toCreateResponse(Client client) {
        return new CreateClientResponse(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhone(),
                client.getCep(),
                client.getLogradouro(),
                client.getBairro(),
                client.getCidade(),
                client.getEstado()
        );
    }
}
