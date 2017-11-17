/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lurguers
 */
public class Dao {
 private Session session;
    private SessionFactory sf;
    public Dao(){
        this.sf = HibernateUtil.getSessionFactory();
    }
    public List consultar(Class classe, String coluna, Object parametro){
        this.session = this.sf.openSession();
        Criteria crit = this.session.createCriteria(classe);
        crit.add(Restrictions.eq(coluna, parametro));
            List<Object> lista = crit.list();
            session.close();
            return lista;
    }
    
    public List consultarlike(Class classe, String coluna, String parametro){
        this.session = this.sf.openSession();
        Criteria query = session.createCriteria(classe);
        query.add(Restrictions.like(coluna, parametro, MatchMode.ANYWHERE));
            List<Object> lista = query.list();
            session.close();
            return lista;
    }
    
    public void inserir(Object objeto){
        this.session = this.sf.openSession();
        Transaction tx = session.beginTransaction();
        this.session.saveOrUpdate(objeto);
        tx.commit();
        session.flush();
        session.close();
    }    
    
    public boolean deletar(Object o){  
        try{
        this.session = this.sf.openSession();
        Transaction tx = session.beginTransaction();
        this.session.delete(o);
        tx.commit();
        session.flush();
        session.close();      
        return true;
        }catch(Exception e){
            return false;
        }
    }  
    
}
