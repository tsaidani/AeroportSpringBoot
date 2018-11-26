package aeroportSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Adresse;
import model.Client;
import model.Reservation;
import repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public void createClient(Client client) {
		if (client != null) {
			clientRepository.save(client);
		}
	}

	public void deleteClient(Client client) {
		if (client != null) {
			clientRepository.delete(client);
		}
	}
	
	
	public void deleteClientById(Integer id) {
		if (clientRepository.findById(id).isPresent()) {
			clientRepository.delete(clientRepository.findById(id).get());
		}
		
	}
	
	public void deleteClientByName(String name) {
		clientRepository.delete(clientRepository.findByClientName(name));
	}

	public void modifyClientName(Client client, String name) {
		if (name != null) {
			client.setClientName(name);
			clientRepository.save(client);
		}
	}

	public void modifyClientCellNumber(Client client, Integer cellNumber) {
		if (cellNumber != null) {
			client.setNumeroTel(cellNumber);
			clientRepository.save(client);
		}

	}

	public void modifyClientFaxNumber(Client client, Integer faxNumber) {
		client.setNumeroFax(faxNumber);
		clientRepository.save(client);
	}

	public void modifyClientMail(Client client, String mail) {
		if (mail != null) {
			client.setMail(mail);
			clientRepository.save(client);
		}

	}

	public void modifyClientAdress(Client client, Adresse adress) {
		if (adress != null) {
			client.setAdresse(adress);
			clientRepository.save(client);
		}
	}
	
	public Client findClientByName(String nom) {
		Client client=clientRepository.findByClientName(nom);
		return client;
	}
	public Client findClientById(Integer id) {
		Client client= clientRepository.findById(id).get();
		return client;
	}
	
	public List<Client> findAllClients(){
		return clientRepository.findAll();
	}

	public List<Reservation> showReservationByClient(Integer idClient){
		Optional<Client> opt = clientRepository.findClientWithReservation(idClient);
		List<Reservation> reservations = null;
		if (opt.isPresent()) {
			Client client = opt.get();
			reservations = client.getReservations();
		}
		return reservations ;	
	}
	
	public Client findClientWithReservation(Integer clientId) {
		return clientRepository.findClientWithReservation(clientId).get();
	}
}
