/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Patrick
 */
public class CombinedDTO {
    
    
    FoodWasteDTO foodwaste;
    VejrDataDTO vejret;

    public CombinedDTO(FoodWasteDTO foodwaste, VejrDTO vejret) {
        this.foodwaste = foodwaste;
        this.vejret = vejret.CurrentData;
    }

    public FoodWasteDTO getFoodwaste() {
        return foodwaste;
    }

    public void setFoodwaste(FoodWasteDTO foodwaste) {
        this.foodwaste = foodwaste;
    }

    public VejrDataDTO getVejret() {
        return vejret;
    }

    public void setVejret(VejrDataDTO vejret) {
        this.vejret = vejret;
    }
    
    
    
}
