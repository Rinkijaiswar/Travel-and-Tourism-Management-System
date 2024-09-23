package com.Customer.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

    public static void main(String[] args) {
        // Create SessionFactory and Session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        // Start transaction
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Uncomment and use this code to add a new Question and its Answers
            /*
            Question q1 = new Question();
            q1.setQuestionId(101);
            q1.setQuestion("What is Java");

            Answer a1 = new Answer();
            a1.setAnswerId(201);
            a1.setAnswer("Java is a programming language");
            a1.setQuestion(q1);

            Answer a2 = new Answer();
            a2.setAnswerId(202);
            a2.setAnswer("It is a platform independent language");
            a2.setQuestion(q1);

            List<Answer> answers = new ArrayList<>();
            answers.add(a1);
            answers.add(a2);

            q1.setAnswers(answers);

            session.save(q1);
            */

            // Retrieve and display data
            Question question = session.get(Question.class, 101);
            if (question != null) {
                System.out.println(question.getQuestion());
                System.out.println("Answers:");
                for (Answer ans : question.getAnswers()) {
                    System.out.println(ans.getAnswer());
                }
            } else {
                System.out.println("Question not found");
            }

            // Commit transaction
            tx.commit();
        } catch (Exception e) {
            // Rollback transaction in case of error
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session and factory
            session.close();
            factory.close();
        }
    }
}
