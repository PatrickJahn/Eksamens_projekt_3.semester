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
public class CombinedDTO {
    List<FoodWasteDTO> fwDTO; 

    public CombinedDTO(List<FoodWasteDTO> fwDTO) {
        this.fwDTO = fwDTO;
    }

    public List<FoodWasteDTO> getFwDTO() {
        return fwDTO;
    }

    public void setFwDTO(List<FoodWasteDTO> fwDTO) {
        this.fwDTO = fwDTO;
    }
    
    
}
