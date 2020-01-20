package com.alexf.springmvccofetarie.service;

import com.alexf.springmvccofetarie.dto.ClientDTO;
import com.alexf.springmvccofetarie.model.Client;
import com.alexf.springmvccofetarie.repository.ClientRepository;
import com.alexf.springmvccofetarie.transformers.ClientTransformer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private ClientTransformer clientTransformer;

    public Client mapDTOToEntity(ClientDTO clientDTO) {
        return clientTransformer.transformToDTO(clientDTO);
    }

    public boolean verificaClientDB(Integer id) {
        return clientRepository.findById(id).isPresent();
    }

    public Client findClientById(int id) {
        return clientRepository.findById(id).get();
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }


    public Client addClient(ClientDTO clientNou) {
        Client client = clientTransformer.transformToDTO(clientNou);
        return clientRepository.save(client);
    }


    public List<Client> addClients(List<Client> clienti) {
        return clientRepository.saveAll(clienti);
    }

    public void removeClientById(int id) {
        clientRepository.deleteById(id);
    }

    public void removeAllClients() {
        clientRepository.deleteAll();
    }
}
