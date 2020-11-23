/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Madsj
 */
public class FoodWasteDTO {

    StoreDTO store;
    ClearanceDTO clearances;

    public FoodWasteDTO(StoreDTO store, ClearanceDTO clearances) {
        this.store = store;
        this.clearances = clearances;
    }

    
    
    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public ClearanceDTO getClearances() {
        return clearances;
    }

    public void setClearances(ClearanceDTO clearances) {
        this.clearances = clearances;
    }

}
