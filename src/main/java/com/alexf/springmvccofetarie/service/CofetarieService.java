package com.alexf.springmvccofetarie.service;

import com.alexf.springmvccofetarie.dto.CofetarieDTO;
import com.alexf.springmvccofetarie.model.Cofetarie;
import com.alexf.springmvccofetarie.repository.CofetarieRepository;
import com.alexf.springmvccofetarie.transformers.CofetarieTransformer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
@Slf4j
public class CofetarieService {
    @Autowired
    private CofetarieRepository cofetarieRepository;

    @Autowired
    private CofetarieTransformer cofetarieTransformer;

    @Autowired
    private ClientService clientService;

    public Cofetarie mapDTOToEntity(CofetarieDTO cofetarieDTO) {
        return cofetarieTransformer.transformToDTO(cofetarieDTO);
    }

    public Cofetarie adaugaCofetarieNoua(Cofetarie cofetarieNoua) {
        List<Integer> listaIdClienti = cofetarieNoua.getClientList().stream().map(clientID -> clientID.getId_client()).collect(Collectors.toList());
        listaIdClienti.forEach(clientID -> {
            if (clientService.verificaClientDB(clientID)) {
                cofetarieRepository.save(cofetarieNoua);
            } else {
                log.info("mesaj ceva");
            }

        });
        return null;
    }

    public List<Cofetarie> adaugaCofetarii(List<Cofetarie> cofetariiNoi) {
        return cofetarieRepository.saveAll(cofetariiNoi);
    }

    public List<Cofetarie> afiseazaToateCofetariile() {
        return cofetarieRepository.findAll();
    }

    public Cofetarie afiseazaCofetarieSpecifica(int id) {
        return cofetarieRepository.findById(id).get();
    }

//    public Cofetarie updateListaClienti(CofetarieDTO cofetarieToUpdate, int id) {
//        Cofetarie c = afiseazaCofetarieSpecifica(id);
//        c.getId_clienti();
//        if (clientService.verificaClientDB(cofetarieToUpdate.getId_clienti())) {
//            cofetarieToUpdate.setId_clienti();
//
//            return cofetarieRepository.u;
//        }
//
//    }
}
