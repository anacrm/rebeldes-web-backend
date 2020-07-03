package com.anacrm.rebeldeswebbackend.controller;

import com.anacrm.rebeldeswebbackend.model.Location;
import com.anacrm.rebeldeswebbackend.model.Negotiation;
import com.anacrm.rebeldeswebbackend.model.Rebel;
import com.anacrm.rebeldeswebbackend.model.Report;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController // informa spring que a class é um controller
@RequestMapping("/api")  //add prefixo api em todos endpoints da classe
public class RebelController {

    /**
     * Usado para armazeras os rebeldes.Idealmente usariamos um banco de dados para tarefa.
     */
    private ArrayList<Rebel> rebels = new ArrayList<>();

    /**
     * Retorna um ArrayList com todos os rebeldes criados.
     * @return
     */
    @GetMapping("/all")
    public ArrayList<Rebel> all(){
        return rebels;
    }

    /**
     * Adiciona um rebelde no sistema
     * @param rebel O rebelde a ser adicionado no sistema
     * @return O rebelde adicionado com Id.
     */
    @PostMapping("/rebel")
    public Rebel createRebel(@RequestBody Rebel rebel) {

        rebels.add(rebel);
        return rebel;
    }

    /**
     * Atualiza a localizacao do Rebelde.
     * @param id Id do Rebelde a ter a localizacao atualizada
     * @param location Nova localizacao
     * @return O rebelde com a localizacao atualizada
     */
    @PutMapping("/rebel/{id}/location")
    public Rebel updateLocation(@PathVariable("id") int id, @RequestBody Location location) {

        Rebel rebel =  this.getRebel(id);

        checkRebelNotNull(rebel);

        rebel.setLocation(location);

        return rebel;
    }

    /**
     * Denuncia um Rebelde como traidor
     * @param id Id do Rebelde a ser denunciado
     * @return Rebelde denunciado.
     */
    @PutMapping("/rebel/{id}/report")
    public Rebel reportRebel (@PathVariable("id") int id) {

        Rebel rebel = this.getRebel(id);

        checkRebelNotNull(rebel);
        rebel.addReport();
        return rebel;
    }

    /**
     * Realiza a troca de itens entre dois Rebeldes
     * @param negotiation Descricao da troca
     * @return O rebelde comprador
     */
    @PutMapping("/negotiate")
    public Rebel negotiate(@RequestBody Negotiation negotiation){

        Rebel buyer = this.getRebel(negotiation.getBuyerId());
        Rebel seller = this.getRebel(negotiation.getSellerId());

        checkRebelNotNull(buyer);
        checkRebelNotNull(seller);

        if (negotiation.getBuyerOffer().getPoints() != negotiation.getSellerOffer().getPoints()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't negotiate offers with different points");
        }

        if (buyer.isTraitor() || seller.isTraitor()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't negotiate offers with traitors");
        }

        buyer.getInventory().subtract(negotiation.getBuyerOffer());
        buyer.getInventory().add(negotiation.getSellerOffer());
        seller.getInventory().subtract(negotiation.getSellerOffer());
        seller.getInventory().add(negotiation.getBuyerOffer());

        return buyer;
    }

    /**
     * Gera e retorna um relatorio completo com informacoes sobre o sistema
     * @return Relatorio gerado
     */
    @GetMapping("/completeReport")
    public Report completeReport() {

        float amountRebels = this.rebels.size();
        float amountTraitors=0;
        int lostPoints = 0;
        int amountWeapons=0;
        int amountAmmo=0;
        int amountWater=0;
        int amountFood=0;


        for (Rebel rebel:this.rebels) {
            if(rebel.isTraitor()){
                amountTraitors++;
                lostPoints +=  rebel.getInventory().getPoints();
            }else {
                amountWeapons += rebel.getInventory().getWeapons();
                amountAmmo += rebel.getInventory().getAmmo();
                amountWater += rebel.getInventory().getWater();
                amountFood += rebel.getInventory().getFood();

            }
        }
        float averageWeapons = amountWeapons/(amountRebels-amountTraitors);
        float averageAmmo = amountAmmo/(amountRebels-amountTraitors);
        float averageWater = amountWater/(amountRebels-amountTraitors);
        float averageFood = amountFood/(amountRebels-amountTraitors);

        float percentTraitors = amountTraitors/amountRebels;



        return new Report(percentTraitors,(1-percentTraitors),lostPoints,averageWeapons,averageAmmo
                ,averageWater,averageFood);

    }

    /**
     * Verifica se o rebelde e nulo. Lanca 404 caso for nulo.
     * @param rebel
     */
    private void checkRebelNotNull(Rebel rebel) {
        if (rebel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rebel not found");
        }
    }

    /**
     * Procura pelo rebelde com Id especificado
     * @param id
     * @return O Rebelde com o id especificado caso ele exista, null caso contrario.
     */
    public Rebel getRebel (int id) {

        for (Rebel rebel:this.rebels) {
            if(rebel.getId() == id){
                return rebel;
            }
        }
        return null;
    }



}
