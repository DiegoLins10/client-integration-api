package com.github.diegolins10.clientapi.application.usecases;

import com.github.diegolins10.clientapi.application.common.Result;
import com.github.diegolins10.clientapi.domain.entities.Client;
import com.github.diegolins10.clientapi.domain.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllClientsUseCase {

    private final ClientRepository clientRepository;

    public Result<List<Client>> execute() {
        return Result.success(clientRepository.findAll());
    }
}
