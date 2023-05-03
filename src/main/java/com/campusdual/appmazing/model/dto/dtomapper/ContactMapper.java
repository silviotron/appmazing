package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDto toDTO(Contact Contact);

    List<ContactDto> toDTOList(List<Contact> Contacts);

    Contact toEntity(ContactDto contactdto);

}
