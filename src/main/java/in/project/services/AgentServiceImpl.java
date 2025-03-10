package in.project.services;
import java.util.List;
import java.util.Optional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.project.entity.AgentEntity;
import in.project.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentRepository agentRepository;

//	@Override
//	public AgentEntity saveAgent(AgentEntity agent) {
//		return agentRepository.save(agent);
//	}
	
	
	
	@Override
	public AgentEntity saveAgent(AgentEntity agent) throws Exception {
	    if (agentRepository.findByEmail(agent.getEmail()).isPresent()) {
	        throw new BadRequestException("Email already exists. Please use another email.");
	    }
	    return agentRepository.save(agent);
	}

	
	

	@Override
	public List<AgentEntity> getAllAgents() {
		return agentRepository.findAll();
	}
		public Optional<AgentEntity> getAgentEmail(String email) {
			return agentRepository.findByEmail(email);
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
			uA.setCompanyName(agent.getCompanyName());
			uA.setServiceCoverage(agent.getServiceCoverage());
			uA.setPricePerKm(agent.getPricePerKm());
			uA.setVehicleType(agent.getVehicleType());
			uA.setNumberOfVehicles(agent.getNumberOfVehicles());
			uA.setServices(agent.getServices());
			uA.setExperience(agent.getExperience());
			uA.setAddress(agent.getAddress());
			uA.setCountry(agent.getCountry());

	            return agentRepository.save(uA);
		}
		return null;
	}

	@Override
	public void deleteAgent(Long agentId) {
		agentRepository.deleteById(agentId);
	}
	

    // Login method
	@Override
	public AgentEntity loginAgent(String email, String password) throws Exception {
		   Optional<AgentEntity> AgentOptional = agentRepository.findByEmail(email);

	        if (AgentOptional.isPresent()) {
	            AgentEntity agent = AgentOptional.get();
	            if (agent.getPassword().equals(password)) {
	                return agent; // Successful login
	            } else {
	                throw new BadRequestException("Invalid email or password!");
	            }
	        } else {
	            throw new BadRequestException("Customer not found with email: " + email);
	        }
	}




	@Override
	public Optional<AgentEntity> getAgentById(Long agentId) {
		return  agentRepository.findById(agentId);
		
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