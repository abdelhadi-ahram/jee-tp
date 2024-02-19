package tp1.presentation;

import tp1.dao.DaoImpl;
import tp1.dao.IDao;
import tp1.metier.IMetier;
import tp1.metier.MetierImpl;

import java.util.Scanner;

public class App {
    public void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Hello World");

        IDao dao = new DaoImpl();
        IMetier metier = new MetierImpl();
        ((MetierImpl) metier).setDao(dao);

        System.out.println(metier.caculate());

        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();

        Class cDao = Class.forName(className);
        IDao dao1 = (IDao) cDao.newInstance();

        className = scanner.nextLine();
        Class cMetier = Class.forName(className);
        IMetier metier1 = (IMetier) cMetier.newInstance();
        ((MetierImpl) metier1).setDao(dao1);

        System.out.println(metier1.caculate());
    }


}
