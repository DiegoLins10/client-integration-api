package com.github.diegolins10.clientapi.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.diegolins10.clientapi.api.dto.CreateClientRequest;
import com.github.diegolins10.clientapi.application.common.Result;
import com.github.diegolins10.clientapi.domain.entities.Client;
import com.github.diegolins10.clientapi.domain.repositories.ClientRepository;

class CreateClientUseCaseTest {

    private ClientRepository clientRepository;
    private CreateClientUseCase createClientUseCase;

    @BeforeEach
    void setUp() {
        clientRepository = Mockito.mock(ClientRepository.class);
        createClientUseCase = new CreateClientUseCase(clientRepository);
    }

    @Test
    void shouldCreateClientSuccessfully() {
        CreateClientRequest request = new CreateClientRequest(
                null,
                "Diego",
                "Lins",
                "diego@email.com",
                "123456789",
                "08132470"
        );

        Client savedClient = new Client(
                1L,
                "Diego",
                "Lins",
                "diego@email.com",
                "123456789",
                "08132470"
        );

        when(clientRepository.save(any(Client.class)))
                .thenReturn(savedClient);

        Result<Client> result = createClientUseCase.execute(request);

        assertTrue(result.isSuccess());
        assertEquals(1L, result.getData().getId());

        ArgumentCaptor<Client> captor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(captor.capture());

        Client clientPassed = captor.getValue();
        assertEquals("Diego", clientPassed.getFirstName());
        assertEquals("Lins", clientPassed.getLastName());
        assertEquals("diego@email.com", clientPassed.getEmail());
        assertEquals("123456789", clientPassed.getPhone());
        assertEquals("08132470", clientPassed.getCep());
    }

}
