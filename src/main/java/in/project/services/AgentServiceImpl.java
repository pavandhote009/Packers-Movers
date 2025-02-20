package in.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AgentEntity;
import in.project.entity.CustomerEntity;
import in.project.repository.AgentRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public AgentEntity saveAgent(AgentEntity agent) {
		return agentRepository.save(agent);
	}

	@Override
	public List<AgentEntity> getAllAgents() {
		return agentRepository.findAll();
	}

	@Override
	public Optional<AgentEntity> getAgentById(Long agentId) {
		return agentRepository.findById(agentId);
	}

	@Override
	public AgentEntity updateAgent(Long agentId, AgentEntity agent) {
		if (agentRepository.existsById(agentId)) {
//			agent.setAgentId(agentId);
//			return agentRepository.save(agent);
	        Optional<AgentEntity> existingagent = agentRepository.findById(agentId);

			AgentEntity uA = existingagent.get();
			uA.setEmail(agent.getEmail());
			uA.setPassword(agent.getPassword());
			uA.setBusinessName(agent.getBusinessName());
			uA.setServiceModel(agent.getServiceModel());
			uA.setExperience(agent.getExperience());
			uA.setAvailability(agent.getAvailability());
			uA.setAddress(agent.getAddress());
			uA.setStatus(agent.getStatus());
			uA.setRating(agent.getRating());
			uA.setCountry(agent.getCountry());

	            return agentRepository.save(uA);
		}
		return null;
	}

	@Override
	public void deleteAgent(Long agentId) {
		agentRepository.deleteById(agentId);
	}
}
//private Long agentId;
//private String email;
//private String password;
//private String businessName;
//private String serviceModel;
//private String experience;
//private String availability;
//private String address;
//private String status;
//private Double rating;
//private String country;