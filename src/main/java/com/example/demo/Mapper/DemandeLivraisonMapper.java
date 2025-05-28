
package com.example.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDTO.DemandeLivraisonDTO;
import com.example.demo.Mapper.ColisMapperr;
import com.example.demo.Mapper.LivraisonMapper;

@Mapper(componentModel = "spring", uses = {ColisMapperr.class, LivraisonMapper.class})
public interface DemandeLivraisonMapper {

    DemandeLivraisonMapper INSTANCE = Mappers.getMapper(DemandeLivraisonMapper.class);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.fullName", target = "clientFullName")
    @Mapping(source = "livreur.id", target = "livreurId")
    @Mapping(source = "livreur.fullName", target = "livreurFullName")
    @Mapping(source ="client.adress" ,target = "adress")
    @Mapping(source="client.phoneNumber" , target = "phoneNumber")
    DemandeLivraisonDTO toDto(DemandeLivraison entity);
    DemandeLivraison toEntity (DemandeLivraisonDTO dto);

   
}
