/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.controller;

import brewery.src.model.DBUtil;
import brewery.src.model.Breweries;
import brewery.src.model.BreweriesGeocode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author k00203657
 */
@Service
public class BreweriesService {

    static List<Breweries> BreweriesList = new ArrayList();

    public List<Breweries> getAllBreweries() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        String q = "SELECT b FROM Breweries b";
        TypedQuery<Breweries> tq = em.createQuery(q, Breweries.class);

        List<Breweries> list;
        try {
            list = tq.getResultList();
            if (list == null || list.isEmpty()) {
                list = null;
            }

        } finally {
            em.close();
        }
        return list;
    }

    public void addAnBreweries(Breweries brewerie) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Date date = new Date();
        brewerie.setLastMod(date);
        brewerie.setId(1);
        try {
            trans.begin();
            em.persist(brewerie);
            trans.commit();

 //           BreweriesGeocode bg = new BreweriesGeocode();
//            bg.setBreweryId((Integer) brewerie.getId());
//            bg.setLongitude((float)brewerie.getLongitude());
//            bg.setLatitude((float)brewerie.getLatitude());
//             trans.begin();
//            em.persist(bg);
//            trans.commit();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
    }

    public void deleteAnBrewery(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            BreweriesGeocode bg = em.createNamedQuery("BreweriesGeocode.findByBreweryId", BreweriesGeocode.class)
                    .setParameter("breweryId", id)
                    .getSingleResult();

            Breweries b = em.createNamedQuery("Breweries.findById", Breweries.class)
                    .setParameter("id", (id))
                    .getSingleResult();

            trans.begin();
            em.remove(em.merge(b));
            em.remove(em.merge(bg));
            trans.commit();
        } catch (Exception ex) {
            System.out.println("Error in getting property details: " + ex);
        } finally {
            em.clear();
            em.close();
        }

    }
    

    
     public Breweries getBrewereriesID(int id)
    {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        Breweries brewery = em.find(Breweries.class, id);
        
        return brewery;
    }
       public boolean updateBrewery(Breweries brewerie) 
    {
         EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Date date = new Date();
        brewerie.setLastMod(date);
//        brewerie.setId(brewerie.getId());
        brewerie.setImage("no_image.jpg");
        
      try{

               trans.begin();
            em.merge(brewerie);
            trans.commit();

 //           BreweriesGeocode bg = new BreweriesGeocode();
//            bg.setBreweryId((Integer) brewerie.getId());
//            bg.setLongitude((float)brewerie.getLongitude());
//            bg.setLatitude((float)brewerie.getLatitude());
//             trans.begin();
//            em.persist(bg);
//            trans.commit();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return true;
    }

       
//            public boolean updateBrewery(Breweries brewerie) 
//    {
//        EntityManager em = DBUtil.getEMF().createEntityManager();
//              
//        em.find(Breweries.class, brewerie.getId());
//        
//        Date date = new Date();        
//        brewerie.setLastMod(date);
//        
//      
//
//        em.getTransaction().begin();
//        em.merge(brewerie);
//        em.getTransaction().commit();
//        
//        return true;
//    }

}
