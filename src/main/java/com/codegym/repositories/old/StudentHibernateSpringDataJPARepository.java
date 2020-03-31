package com.codegym.repositories.old;

import com.codegym.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentHibernateSpringDataJPARepository implements IStudentRepository {

    @PersistenceContext
    EntityManager entityManager;


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

        if (student.getId() != null && student.getId() > 0) {
            this.entityManager.merge(student);
        } else {
            this.entityManager.persist(student);
        }

        return student;
    }
}
