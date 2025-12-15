package com.github.diegolins10.clientapi.api.controllers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

import com.github.diegolins10.clientapi.api.dto.CreateClientRequest;
import com.github.diegolins10.clientapi.api.dto.CreateClientResponse;
import com.github.diegolins10.clientapi.api.responses.RestResult;
import com.github.diegolins10.clientapi.application.common.Result;
import com.github.diegolins10.clientapi.application.usecases.CreateClientUseCase;
import com.github.diegolins10.clientapi.application.usecases.GetAllClientsUseCase;
import com.github.diegolins10.clientapi.domain.entities.Client;

class ClientControllerTest {

    private CreateClientUseCase createClientUseCase;
    private GetAllClientsUseCase getAllClientsUseCase;
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        createClientUseCase = Mockito.mock(CreateClientUseCase.class);
        getAllClientsUseCase = Mockito.mock(GetAllClientsUseCase.class);
        clientController = new ClientController(createClientUseCase, getAllClientsUseCase);
    }

    @Test
    void shouldCreateClient() {
        // given
        CreateClientRequest request = new CreateClientRequest(
                1L,
                "Diego",
                "Lins",
                "diego@email.com",
                "123456789",
                "08132470"
        );

        Client client = new Client(
                1L,
                "Diego",
                "Lins",
                "diego@email.com",
                "123456789",
                "08132470"
        );

        when(createClientUseCase.execute(request))
                .thenReturn(Result.success(client));

        // when
        ResponseEntity<RestResult<CreateClientResponse>> response =
                clientController.createClient(request);

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isSuccess());
        assertEquals(1L, response.getBody().getData().id());

        verify(createClientUseCase, times(1)).execute(request);
    }

    @Test
    void shouldGetAllClients() {
        // given
        List<Client> clients = List.of(
                new Client(1L, "Diego", "Lins", "diego@teste.com", "1234567", "08132470"),
                new Client(2L, "Anna", "Senna", "anna@email.com", "987654321", "08132470")
        );

        when(getAllClientsUseCase.execute())
                .thenReturn(Result.success(clients));

        // when
        ResponseEntity<RestResult<List<CreateClientResponse>>> response =
                clientController.getAllClients();

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isSuccess());
        assertEquals(2, response.getBody().getData().size());

        verify(getAllClientsUseCase, times(1)).execute();
    }
}
