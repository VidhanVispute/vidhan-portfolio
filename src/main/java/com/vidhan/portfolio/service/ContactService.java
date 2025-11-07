package com.vidhan.portfolio.service;

import com.vidhan.portfolio.entity.Contact;
import com.vidhan.portfolio.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    public List<Contact> getAllContacts() {
        return contactRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public Contact saveContact(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }
    
    public void markAsRead(Long id) {
        contactRepository.findById(id).ifPresent(contact -> {
            contact.setIsRead(true);
            contactRepository.save(contact);
        });
    }
}