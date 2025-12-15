package com.github.diegolins10.clientapi.application.usecases;

import com.github.diegolins10.clientapi.api.dto.CreateClientRequest;
import com.github.diegolins10.clientapi.application.common.Result;
import com.github.diegolins10.clientapi.domain.entities.Client;
import com.github.diegolins10.clientapi.domain.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClientUseCase {

    private final ClientRepository clientRepository;

    public Result<Client> execute(CreateClientRequest request) {

        if (request.email() == null || request.email().isBlank()) {
            return Result.failure("Email é obrigatório");
        }

        Client client = Client.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .cep(request.cep())
                .build();

        Client savedClient = clientRepository.save(client);

        return Result.success(savedClient);
    }
}
