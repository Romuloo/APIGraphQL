package com.saw.apigrahql.configuration;

import com.saw.apigrahql.entity.BankAccount;
import com.saw.apigrahql.entity.Client;
import com.saw.apigrahql.entity.Vehicle;
import com.saw.apigrahql.repository.AccountRepository;
import com.saw.apigrahql.repository.ClientRepository;
import com.saw.apigrahql.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {



    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository, VehicleRepository vehicleRepository, AccountRepository accountRepository) {

        return args -> {
            long startTime = System.currentTimeMillis();
            for(int i = 7; i <= 1000; i++){
                Client c = new Client((long) i, "DNI_CLIENT_" +i, "CLIENT_"+ i + "_FIRSTNAME", "CLIENT_"+i+"_LASTNAME");
                Vehicle v = new Vehicle((long) i, "PLATE_VEHICLE_" + i, "PUMA", c);
                BankAccount b = new BankAccount((long) i, "IBAN_ACCOUNT_" + i, c);
                clientRepository.save(c);
                vehicleRepository.save(v);
                accountRepository.save(b);
            }
            long endTime = System.currentTimeMillis() - startTime;
            long endTimeS = endTime / 1000;
            System.out.println("El volcado de datos ha tardado " + endTime + " ms.");
            System.out.println("En segundos: " + endTimeS + " s.");
            System.out.println("En minutos: " + endTimeS / 60 + " min.");

            Client c1 = new Client(1L, "49690478X", "Michael", "Scofield");
            Client c2 = new Client(2L, "32646499Y", "Lincoln", "Burrows");
            Client c3 = new Client(3L, "74820183V", "LG", "Burrows");
            Client c4 = new Client(4L, "64728393A", "Fernando", "Sucre");
            Client c5 = new Client(5L, "76842399B", "Sara", "Tancredi");
            Client c6 = new Client(6L, "49684721P", "Alexander", "Mahone");

            Vehicle v1 = new Vehicle(1L, "6966LMG", "MUSTANG", c4);
            Vehicle v2 = new Vehicle(2L, "4321LLP", "SIERRA", c2);
            Vehicle v3 = new Vehicle(3L, "2314LNM", "PUMA", c5);
            Vehicle v4 = new Vehicle(4L, "1234LGM", "MUSTANG", c1);
            Vehicle v5 = new Vehicle(5L, "9023LWX", "FOCUS", c6);
            Vehicle v6 = new Vehicle(6L, "5233LXT", "FIESTA", c3);

            Vehicle v7 = new Vehicle(7L, "7392LDW", "MUSTANG", c2);
            Vehicle v8 = new Vehicle(8L, "1445LMT", "SIERRA", c1);
            Vehicle v9 = new Vehicle(9L, "9128LXZ", "SIERRA", c3);
            Vehicle v10 = new Vehicle(10L, "9291LXX", "MUSTANG", c5);
            Vehicle v11 = new Vehicle(11L, "0794LMM", "FOCUS", c1);
            Vehicle v12 = new Vehicle(11L, "1243LJK", "FIESTA", c6);


            BankAccount b1 = new BankAccount(1L, "ES11 736251525", c1);
            BankAccount b2 = new BankAccount(2L, "ES11 126374890", c2);
            BankAccount b3 = new BankAccount(3L, "ES11 985737128", c3);
            BankAccount b4 = new BankAccount(4L, "ES11 312455572", c4);
            BankAccount b5 = new BankAccount(5L, "ES11 631534525", c5);
            BankAccount b6 = new BankAccount(6L, "ES11 414134141", c6);

            clientRepository.save(c1); clientRepository.save(c2) ;clientRepository.save(c3);
            clientRepository.save(c4); clientRepository.save(c5); clientRepository.save(c6);

            vehicleRepository.save(v1); vehicleRepository.save(v2); vehicleRepository.save(v3);
            vehicleRepository.save(v4); vehicleRepository.save(v5); vehicleRepository.save(v6);
            vehicleRepository.save(v7); vehicleRepository.save(v8); vehicleRepository.save(v9);
            vehicleRepository.save(v10); vehicleRepository.save(v11); vehicleRepository.save(v12);

            accountRepository.save(b1);  accountRepository.save(b2); accountRepository.save(b3);
            accountRepository.save(b4);  accountRepository.save(b5); accountRepository.save(b6);





        };
    }



}
