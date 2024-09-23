package com.Customer.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Customer.Dao.TourPackageDao;
import com.Customer.entity.TourPackage;
import com.Customer.util.HibernateUtil;

public class TourPackageDaoImp implements TourPackageDao {

    @Override
    public TourPackage createTourPackage(TourPackage tourPackage) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(tourPackage);
            session.getTransaction().commit();
            return tourPackage;
        } catch (HibernateException e) {
            // Log the exception instead of printing it
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TourPackage getTourPackage(String tourPackageID) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(TourPackage.class, tourPackageID);
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TourPackage> getAllTourPackages() {
        try (Session session = HibernateUtil.getSession()) {
            Query<TourPackage> query = session.createQuery("from TourPackage", TourPackage.class);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TourPackage updateTourPackage(String packageID, TourPackage updatedTourPackage) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            TourPackage existingTourPackage = session.get(TourPackage.class, packageID);
            if (existingTourPackage != null) {
                // Update fields here (e.g., existingTourPackage.setName(updatedTourPackage.getName());)
                existingTourPackage.setName(updatedTourPackage.getName()); // example
                session.update(existingTourPackage);
                session.getTransaction().commit();
                return existingTourPackage;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteTourPackage(String packageID) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            TourPackage tourPackage = session.get(TourPackage.class, packageID);
            if (tourPackage != null) {
                session.delete(tourPackage);
                session.getTransaction().commit();
                return "Tour Package with ID: " + packageID + " was deleted successfully.";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Tour Package with ID: " + packageID + " could not be deleted.";
    }
}
