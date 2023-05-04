package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto queryContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        return ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contact.getId()));

    }

    @Override
    public List<ContactDto> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    @Override
    public int insertContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDto contactDto) {
        return insertContact(contactDto);
    }
    @Override
    public int secureUpdateContact(ContactDto contactDto) {
        ContactDto c = queryContact(contactDto);
        if (c != null) {
            if (contactDto.getName() == null) {
                contactDto.setName(c.getName());
            }
            if (contactDto.getSurname() == null) {
                contactDto.setSurname(c.getSurname());
            }
            if (contactDto.getSurname2() == null) {
                contactDto.setSurname2(c.getSurname2());
            }
            if (contactDto.getTelephone() == null) {
                contactDto.setTelephone(c.getTelephone());
            }
            if (contactDto.getEmail() == null) {
                contactDto.setEmail(c.getEmail());
            }
        }
        return insertContact(contactDto);
    }

    @Override
    public int deleteContact(ContactDto contactDto) {
        int id = contactDto.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.delete(contact);
        return id;
    }
}
