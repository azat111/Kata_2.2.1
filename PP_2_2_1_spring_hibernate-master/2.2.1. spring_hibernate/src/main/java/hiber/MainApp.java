package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      SessionFactory sessionFactory= context.getBean(SessionFactory.class);

      try (Session session = sessionFactory.openSession()) {
           session.beginTransaction();
//         User user = session.get(User.class, 1L);
//         User user2 = session.get(User.class, 2L);
//         User user3 = session.get(User.class, 3L);
//         Car car = new Car("Lada",4);
//         Car car2 = new Car("BMW",5);
//         Car car3 = new Car("Honda",6);
//         user.setCar(car);
//         user2.setCar(car2);
//         user3.setCar(car3);
         System.out.println(userService.getUser("Honda",6));
         session.getTransaction().commit();
      }

      context.close();
   }
}
