package com.gelinski.apiBtgChallenge.mapper;

import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTOV1 entityToDTO(ClientEntity clientEntity);

    ClientEntity dtoToEntity(ClientDTOV1 clientDTO);

    List<ClientDTOV1> mapToDTO(List<ClientEntity> clientEntities);

    List<ClientEntity> mapToEntity(List<ClientDTOV1> clientDTOs);

}
