package com.github.diegolins10.clientapi.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.diegolins10.clientapi.api.dto.CreateClientRequest;
import com.github.diegolins10.clientapi.api.dto.CreateClientResponse;
import com.github.diegolins10.clientapi.api.mappers.ClientApiMapper;
import com.github.diegolins10.clientapi.api.responses.RestResult;
import com.github.diegolins10.clientapi.application.common.Result;
import com.github.diegolins10.clientapi.application.usecases.CreateClientUseCase;
import com.github.diegolins10.clientapi.application.usecases.GetAllClientsUseCase;
import com.github.diegolins10.clientapi.domain.entities.Client;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final GetAllClientsUseCase getAllClientsUseCase;

    @PostMapping
    public ResponseEntity<RestResult<CreateClientResponse>> createClient(@RequestBody CreateClientRequest request) {

        Result<Client> result = createClientUseCase.execute(request);

        if (result.isSuccess()) {
            CreateClientResponse response =
                    ClientApiMapper.toCreateResponse(result.getData());

            return ResponseEntity.ok(
                    RestResult.ok(response)
            );
        }

        return ResponseEntity.badRequest()
                .body(RestResult.error(result.getError()));
    }

    @GetMapping
    public ResponseEntity<RestResult<List<CreateClientResponse>>> getAllClients() {

        Result<List<Client>> result = getAllClientsUseCase.execute();

        if (result.isSuccess()) {
            List<CreateClientResponse> response = result.getData()
                    .stream()
                    .map(ClientApiMapper::toCreateResponse)
                    .toList();

            return ResponseEntity.ok(
                    RestResult.ok(response)
            );
        }

        return ResponseEntity.internalServerError()
                .body(RestResult.error(result.getError()));
    }
}
