package com.saw.apigrahql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.saw.apigrahql.entity.BankAccount;
import com.saw.apigrahql.entity.Client;
import com.saw.apigrahql.entity.Vehicle;
import com.saw.apigrahql.repository.AccountRepository;
import com.saw.apigrahql.repository.ClientRepository;
import com.saw.apigrahql.repository.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    public Mutation(VehicleRepository vehicleRepository, ClientRepository clientRepository, AccountRepository accountRepository){
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Client newClient(Long id, String dni, String fname, String lname){
        Client client = new Client(id, dni, fname, lname);
        clientRepository.save(client);
        return client;
    }

    public boolean deleteClient(Long id){
        clientRepository.deleteById(id);
        return true;
    }

    public Client updateClientDNI(String newDni, Long id) throws ClassNotFoundException {

        if (clientRepository.findById(id).isPresent()) {
            Client client = clientRepository.findById(id).get();
            client.setDni(newDni);
            clientRepository.save(client);
            return client;
        } else {
            throw new ClassNotFoundException("Client not found");
        }
    }

        public Vehicle newVehicle(Long id, String plate, String model, Long client_id) throws ClassNotFoundException {

            if(clientRepository.findById(client_id).isPresent()){
                Client vehiclesOwner = clientRepository.findById(client_id).get();
                Vehicle vehicle = new Vehicle(id, plate, model, vehiclesOwner);
                vehicleRepository.save(vehicle);
                return vehicle;
            }
            else{
                throw new ClassNotFoundException("Vehicle's Owner not found");
            }

        }

        public BankAccount newBankAccount(Long id, String iban, Long client_id) throws ClassNotFoundException {

        if(clientRepository.findById(client_id).isPresent()){
                Client accountsOwner = clientRepository.findById(client_id).get();
                BankAccount account = new BankAccount(id, iban, accountsOwner);
                accountRepository.save(account);
                return account;
            }
            else{
                throw new ClassNotFoundException("Account's Owner not found");
            }
        }

}
