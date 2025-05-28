package com.example.demo.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.ModelDTO.LivraisonDTO;
import com.example.demo.ModelDomain.Livraison;

public interface LivraisonMapper {
    

    LivraisonMapper INSTANCE = Mappers.getMapper(LivraisonMapper.class);

   
    @Mapping(source ="livreur.id" ,target = "livreurId")
    @Mapping(source="demandeLivraison.id" , target = "demandeLivraisonId")
    LivraisonDTO toDto(Livraison entity);
    Livraison toEntity (LivraisonDTO dto);

   


}
