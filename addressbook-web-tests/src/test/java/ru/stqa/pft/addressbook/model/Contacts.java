package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    public Contacts(Contacts contact) {
        this.delegate = new HashSet<>(contact.delegate);
    }

    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;

    }

    public Contacts withOut(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;

    }

}
