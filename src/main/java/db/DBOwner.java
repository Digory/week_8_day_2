package db;

import models.Folder;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {
    private static Session session;

    public static List<Folder> getAllFoldersOwnedBy(Owner owner){
        List<Folder> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Folder.class);
            cr.add(Restrictions.eq("owner", owner));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return results;
    }
}
