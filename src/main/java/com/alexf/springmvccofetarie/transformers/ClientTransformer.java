package com.alexf.springmvccofetarie.transformers;

import com.alexf.springmvccofetarie.dto.ClientDTO;
import com.alexf.springmvccofetarie.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Builder
@AllArgsConstructor
@Service
public class ClientTransformer {

    public Client transformToDTO(ClientDTO clientDTO) {
        Client client = Client.builder().nume(clientDTO.getNume()).prenume(clientDTO.getPrenume()).
                adresa(clientDTO.getAdresa()).varsta(clientDTO.getVarsta()).clientFidel(clientDTO.isClientFidel()).build();
        return client;
    }
}
