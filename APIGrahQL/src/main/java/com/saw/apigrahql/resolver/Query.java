package com.saw.apigrahql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.saw.apigrahql.entity.*;
import com.saw.apigrahql.repository.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final VehicleRepository vehicleRepository;

    public Query(ClientRepository clientRepository, AccountRepository accountRepository, VehicleRepository vehicleRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<Client> findAllClients(int limit, int first, boolean asc) {
        return (asc) ? clientRepository.findAll().stream().skip(first).limit(limit).collect(Collectors.toList()) :
                clientRepository.findAll().stream().sorted(Comparator.comparing(Client::getId).reversed()).skip(first).limit(limit).collect(Collectors.toList());
    }

    public List<BankAccount> findAllBankAccounts(int limit, int first, boolean asc){
        return (asc) ? accountRepository.findAll().stream().skip(first).limit(limit).collect(Collectors.toList()) :
                accountRepository.findAll().stream().sorted(Comparator.comparing(BankAccount::getId).reversed()).skip(first).limit(limit).collect(Collectors.toList());    }

    public List<Vehicle> findAllVehicles(int limit, int first, boolean asc){
        return (asc) ? vehicleRepository.findAll().stream().skip(first).limit(limit).collect(Collectors.toList()) :
                vehicleRepository.findAll().stream().sorted(Comparator.comparing(Vehicle::getId).reversed()).skip(first).limit(limit).collect(Collectors.toList());
    }

    public Client findClient(Long id) throws ClassNotFoundException {

        if(clientRepository.findById(id).isPresent()){
            Client client = clientRepository.findById(id).get();
            return client;
        }
        else{
            throw new ClassNotFoundException("Client not found");
        }
    }

    public List<Client> findClientsByLastName(String lname){
        return clientRepository.findAll().stream().filter(c -> c.getLname().equals(lname)).collect(Collectors.toList());
    }

    public Client findClientByDni(String dni) throws Exception {
        List<Client> list = clientRepository.findAll().stream().filter(c -> c.getDni().equals(dni)).collect(Collectors.toList());
        switch (list.size()){
            case 0:
                throw new NullPointerException("There are not any Client with that DNI");
            case 1:
                return list.get(0);
            default:
                throw new Exception("There are more than one Client using the same DNI");

        }
    }

    public Vehicle findVehicle(Long id) throws ClassNotFoundException {

        if(vehicleRepository.findById(id).isPresent()){
            Vehicle vehicle = vehicleRepository.findById(id).get();
            return vehicle;
        }
        else{
            throw new ClassNotFoundException("Vehicle not found");
        }
    }

    public List<Vehicle> findVehiclesByModel(String model){
        return vehicleRepository.findAll().stream().filter(v -> v.getModel().equals(model)).collect(Collectors.toList());

    }

    public BankAccount findAccount(Long id) throws ClassNotFoundException {

        if(accountRepository.findById(id).isPresent()){
            BankAccount bankAccount = accountRepository.findById(id).get();
            return bankAccount;
        }
        else{
            throw new ClassNotFoundException("Account not found");
        }
    }

}
