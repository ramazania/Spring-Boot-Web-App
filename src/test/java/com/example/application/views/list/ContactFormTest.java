package com.example.application.views.list;

import com.example.application.data.Company;
import com.example.application.data.Contact;
import com.example.application.data.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ContactFormTest {
    private List<Company> companies;
    private List<Status> statuses;
    private Contact marcUsher;
    private Company company1;
    private Company company2;
    private Status status1;
    private Status status2;

    @BeforeEach
    public void setupData() {
        companies = new ArrayList<>();
        company1 = new Company();
        company1.setName("Vaadin Ltd");
        company2 = new Company();
        company2.setName("IT Mill");
        companies.add(company1);
        companies.add(company2);

        statuses = new ArrayList<>();
        status1 = new Status();
        status1.setName("Status 1");
        status2 = new Status();
        status2.setName("Status 2");
        statuses.add(status1);
        statuses.add(status2);

        marcUsher = new Contact();
        marcUsher.setFirstName("Marc");
        marcUsher.setLastName("Usher");
        marcUsher.setEmail("marc@usher.com");
        marcUsher.setStatus(status1);
        marcUsher.setCompany(company2);
    }

    @Test
    public void formFieldsPopulated() {
        ContactForm form = new ContactForm(companies, statuses);
        form.setContact(marcUsher);

        Assertions.assertEquals("Marc", form.firstName.getValue());
        Assertions.assertEquals("Usher", form.lastName.getValue());
        Assertions.assertEquals("marc@usher.com", form.email.getValue());
        Assertions.assertEquals(company2, form.company.getValue());
        Assertions.assertEquals(status1, form.status.getValue());

    }
    @Test
    public void saveEventHasCorrectValues(){
        ContactForm form = new ContactForm(companies, statuses);
        Contact contact = new Contact();
        form.setContact(contact);

        form.firstName.setValue("John");
        form.lastName.setValue("Doe");
        form.email.setValue("john@doe.com");
        form.company.setValue(company1);
        form.status.setValue(status2);

        AtomicReference<Contact> savedContact = new AtomicReference<>(null);
        form.addListener(ContactForm.SaveEvent.class, e -> savedContact.set(e.getContact()));

        form.save.click();
        Contact saved = savedContact.get();

        Assertions.assertEquals("John", saved.getFirstName());
        Assertions.assertEquals("Doe", saved.getLastName());
        Assertions.assertEquals("john@doe.com", saved.getEmail());
        Assertions.assertEquals(company1, saved.getCompany());
        Assertions.assertEquals(status2, saved.getStatus());

    }
}