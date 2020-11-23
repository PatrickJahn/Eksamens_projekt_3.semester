/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author Madsj
 */
public class ClearanceDTO {
    
 List<OfferAndProductDTO> offerAndProductDTO;

    public ClearanceDTO(List<OfferAndProductDTO> offerAndProductDTO) {
        this.offerAndProductDTO = offerAndProductDTO;
    }

    public List<OfferAndProductDTO> getOfferAndProductDTO() {
        return offerAndProductDTO;
    }

    public void setOfferAndProductDTO(List<OfferAndProductDTO> offerAndProductDTO) {
        this.offerAndProductDTO = offerAndProductDTO;
    }

 
}
