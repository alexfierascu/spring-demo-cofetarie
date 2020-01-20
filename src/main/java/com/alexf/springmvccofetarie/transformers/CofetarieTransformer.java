package com.alexf.springmvccofetarie.transformers;

import com.alexf.springmvccofetarie.dto.CofetarieDTO;
import com.alexf.springmvccofetarie.model.Cofetarie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Builder
@AllArgsConstructor
@Service
public class CofetarieTransformer {

    public Cofetarie transformToDTO(CofetarieDTO cofetarieDTO) {
        Cofetarie cofetarie = Cofetarie.builder().numeCofetarie(cofetarieDTO.getNumeCofetarie()).
                adresaCofetarie(cofetarieDTO.getAdresaCofetarie()).clientList(cofetarieDTO.getListaClienti()).build();
        return cofetarie;
    }
}
