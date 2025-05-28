package com.example.demo.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.ModelDomain.Colis;
import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDTO.ColisDTO;
import com.example.demo.ModelDTO.DemandeLivraisonDTO;
import com.example.demo.ModelDTO.LivraisonDTO;

public interface ColisMapperr {


    ColisMapperr  INSTANCE= Mappers.getMapper(ColisMapperr.class) ;

    @Mapping(source = "demandeLivraison.id ",target = "demandeLivraisonId")
     ColisDTO toDto(Colis entity);

    @Mapping(target = "demandeLivraison.id", source = "demandeLivraisonId")
     Colis toEntity (ColisDTO dto);

}
