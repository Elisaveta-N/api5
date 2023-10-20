package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/contacts")
public class ContactController {
    private final ContactRepository contactRepository;

    @GetMapping
    private List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    private Contact getContactById(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact with id = " + id + " not found"));
    }

    @PostMapping
    private Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<?> updateContactById(@PathVariable Long id, @RequestBody Contact contact) {
        Contact contactForUpdate = contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact with id = " + id + " not found"));
        contactForUpdate.setName(contact.getName());
        contactForUpdate.setPhone(contact.getPhone());
        contactRepository.save(contactForUpdate);
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping
    private ResponseEntity<?> deleteAllContacts() {
        contactRepository.deleteAll();
        return ResponseEntity.ok("Contacts have been cleaned");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteContactById(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return ResponseEntity.ok("Contact " + id + " removed");
    }
}

