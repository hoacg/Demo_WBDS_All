package com.codegym.repositories.old;

import com.codegym.models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentHibernateRepository implements IStudentRepository {


    SessionFactory sessionFactory;
    EntityManager entityManager;

    public StudentHibernateRepository() {
        this.sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        this.entityManager = this.sessionFactory.createEntityManager();
    }


    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT s FROM Student s";
        return this.entityManager.createQuery(query, Student.class).getResultList();
    }

    @Override
    public List<Student> getAllStudentsStartWith(String character) {
        String query = "SELECT s FROM Student s WHERE s.name LIKE :name";

        TypedQuery<Student> typedQuery = this.entityManager.createQuery(query, Student.class);
        typedQuery.setParameter("name", character);

        return typedQuery.getResultList();
    }

    @Override
    public Student save(Student student) {
        return null;
    }
}
