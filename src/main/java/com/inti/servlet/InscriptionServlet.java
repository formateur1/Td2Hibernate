package com.inti.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.UAbonne;
import com.inti.model.UVip;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurDetails;
import com.inti.util.HibernateUtil;


@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger log = LogManager.getLogger();
	private Session s;
       
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s = HibernateUtil.getSessionFactory().openSession();
		log.debug("Connexion à la BDD et configuration d'hibernate");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try 
		{
			s.beginTransaction();
			
			log.info("Début enregistrement utilisateur");
			
			Utilisateur u1 = null;
			
			if(request.getParameter("formule").equals("classique"))
			{
				// ajout de commentaire
				u1 = new Utilisateur(request.getParameter("login"), request.getParameter("mdp"));
			}
			else if(request.getParameter("formule").equals("abonne"))
			{
				u1 = new UAbonne(request.getParameter("login"), request.getParameter("mdp"), 12, "informatique");
			}
			else
			{
				u1 = new UVip(request.getParameter("login"), request.getParameter("mdp"), 0.15, 12, 1, 99.99);
			}
			
			
			UtilisateurDetails ud1 = new UtilisateurDetails(request.getParameter("adresse"), 
					request.getParameter("ville"), Integer.parseInt(request.getParameter("cp")), 
					request.getParameter("tel"), request.getParameter("email"));
			
			u1.setUtilisateurDetails(ud1);
			log.info("Liaison entre utilisateur " + u1 + "et utilisateur détail " + ud1);
			
			s.save(u1);
			log.info("utilisateur enregistré");
			
			s.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			
			log.error("Erreur enregistrement utilisateur");
			
			s.getTransaction().rollback();
		}
		
		doGet(request, response);
		
	}

}
