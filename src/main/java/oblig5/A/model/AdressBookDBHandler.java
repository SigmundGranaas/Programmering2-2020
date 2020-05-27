package oblig5.A.model;

import oblig4.B.BonusMember;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class AdressBookDBHandler implements AddressBook {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("contacts-pu");
    @Override
    public void addContact(ContactDetails contact) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();
            em.persist(contact);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(String phoneNumber) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        try{
            ContactDetails c = em.find(ContactDetails.class, phoneNumber);
            em.remove(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<ContactDetails> getAllContacts() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ContactDetails> cq = cb.createQuery(ContactDetails.class);
        Root<ContactDetails> rootEntry = cq.from(ContactDetails.class);
        CriteriaQuery<ContactDetails> all = cq.select(rootEntry);
        TypedQuery<ContactDetails> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Iterator<ContactDetails> iterator() {

        return null;
    }
    public void close(){
    }
}
