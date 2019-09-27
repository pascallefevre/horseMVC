package com.horses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.horses.config.ContextConfiguration;
import com.horses.dao.IHorseDao;
import com.horses.dao.IOwner;
import com.horses.dao.IStable;
import com.horses.domain.EColor;
import com.horses.domain.Horse;
import com.horses.domain.Owner;
import com.horses.domain.Stable;




public class Entry {

	public static void main(String[] args) 
	{
		test1();

	}
	public static void test1()
	{
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		IHorseDao hdao = (IHorseDao) ctx.getBean(IHorseDao.class);
		IOwner odao = (IOwner) ctx.getBean(IOwner.class);
		IStable sdao = (IStable) ctx.getBean(IStable.class);

		Horse h1 = new Horse("Hanovrien", date("01-02-2001") , EColor.Brown);
		Horse h2 = new Horse("Hollandais sand chaud", date("01-02-2001") , EColor.Black);
		Horse h3 = new Horse("Holsteiner", date("01-02-2001") , EColor.White);
		Horse h4 = new Horse("Cheval de sang belge", date("01-02-2001") , EColor.Brown);
		Horse h5 = new Horse("Oldenburg", date("01-02-2001") , EColor.BrownAndWhithe);
		Horse h6 = new Horse("Selle Français", date("01-02-2001") , EColor.Brown);
		Horse h7 = new Horse("Westphalien", date("01-02-2001") , EColor.White);
		Horse h8 = new Horse("Trait irlandais", date("01-02-2001") , EColor.White);
		Horse h9 = new Horse("Lusitanien", date("01-02-2001") , EColor.Brown);
		Horse h10 = new Horse("Pur-Sang Arabe", date("01-02-2001") , EColor.White);
		Horse h11 = new Horse("Hispano-arabe", date("01-02-2001") , EColor.White);
		
		Owner o1 = new Owner("Sabrina", "Arnold", date("03-05-1975"), "Paris");
		Owner o2 = new Owner("Jean-Noël", "Lafaure", date("03-05-1975"), "Paris");
		Owner o3 = new Owner("Catherine", "Roland", date("03-05-1975"), "Paris");
		Owner o4 = new Owner("André", "Chenu", date("03-05-1975"), "Paris");
		Owner o5 = new Owner("Victoria", "Niarchos", date("03-05-1975"), "Paris");
		
		
		Stable s1=new Stable("Grands Pins","Vidauban");
		Stable s2=new Stable("Herrin","Pompogne");
		
		//Dabbord mettre sur base de donnée
		odao.save(o1);odao.save(o2);odao.save(o3);odao.save(o4);
		
		//Ces methodes font un persist sur des éléments déjà en base de donnée
		
		s1.getTheOwners().add(o1);s1.getTheOwners().add(o2);s1.getTheOwners().add(o3);s1.getTheOwners().add(o4);
		s2.getTheOwners().add(o1);s2.getTheOwners().add(o2);s2.getTheOwners().add(o3);s2.getTheOwners().add(o4);
		sdao.save(s1);	sdao.save(s2);
		
		
		
		h1.setMyStable(s2);h2.setMyStable(s2);h3.setMyStable(s1);h4.setMyStable(s1);h5.setMyStable(s1);h6.setMyStable(s1);h7.setMyStable(s2);h8.setMyStable(s2);h9.setMyStable(s2);h10.setMyStable(s2);h11.setMyStable(s1);
	h1.setMyOwner(o1);h2.setMyOwner(o1);h3.setMyOwner(o1);h4.setMyOwner(o2);h5.setMyOwner(o2);h6.setMyOwner(o3);h7.setMyOwner(o3);h8.setMyOwner(o3);h9.setMyOwner(o2);h10.setMyOwner(o2);h11.setMyOwner(o3);
		hdao.save(h1);hdao.save(h2);hdao.save(h3);hdao.save(h4);hdao.save(h5);hdao.save(h6);hdao.save(h7);hdao.save(h8);hdao.save(h9);hdao.save(h10);hdao.save(h11);
		
		
		System.out.println("creat!");
	}
	
	public static Date date(String dd_MM_yyyy)
	{
		Date d= new Date();
		try {
			d = new SimpleDateFormat("dd-MM-yyyy").parse(dd_MM_yyyy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

}
