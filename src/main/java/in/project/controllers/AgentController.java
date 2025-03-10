package in.project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.project.entity.AgentEntity;
import in.project.repository.AgentRepository;
import in.project.services.AgentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class AgentController {
    
    @Autowired
    private AgentService agentService;
    @Autowired
    private AgentRepository agentRepository;
    
    @PostMapping(value = "/agentregister", consumes = {"application/json", "application/xml"}, produces = "application/json")
    public ResponseEntity<?> createAgent(@RequestBody AgentEntity agent) {
            try {
                AgentEntity savedagent = agentService.saveAgent(agent);
                return ResponseEntity.ok(savedagent);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage()); // Return error message if email exists
            }
        }
  
//    	(agentService.saveAgent(agent);)
//    	AgentEntity uA = new AgentEntity();
//
//		uA.setEmail(agent.getEmail());
//		uA.setName(agent.getName());
//		uA.setMobile(agent.getMobile());
//		
//		uA.setPassword(agent.getPassword());
//		uA.setCompanyName(agent.getCompanyName());
//		uA.setServiceCoverage(agent.getServiceCoverage());
//		uA.setPricePerKm(agent.getPricePerKm());
//		uA.setVehicleType(agent.getVehicleType());
//		uA.setNumberOfVehicles(agent.getNumberOfVehicles());
//		uA.setServices(agent.getServices());
//		uA.setExperience(agent.getExperience());
//		uA.setAddress(agent.getAddress());
//		uA.setCountry(agent.getCountry());
//		 agentRepository.save(uA);
    	
//        return ResponseEntity.status(HttpStatus.CREATED).body("Agent registration Succeccfull");
//}

    
    @GetMapping(value = "/agents", produces = "application/json")
    public ResponseEntity<?> getAllAgents() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(agentService.getAllAgents());
    }
   
    @GetMapping("/agent/{agentId}")
	public ResponseEntity<?> getAgentById(@PathVariable Long agentId) {
		try {
			AgentEntity agent = agentService.getAgentById(agentId).get();
			return ResponseEntity.ok(agent);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    	
    }
    
    @PutMapping("/{agentId}")
    public ResponseEntity<AgentEntity> updateAgent(@PathVariable Long agentId, @RequestBody AgentEntity agent) {
        AgentEntity updatedAgent = agentService.updateAgent(agentId, agent);
        return updatedAgent != null ? ResponseEntity.ok(updatedAgent) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{agentId}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long agentId) {
        agentService.deleteAgent(agentId);
        return ResponseEntity.noContent().build();
    }
  
    @PostMapping("/login/2")
    public ResponseEntity<?> loginAgent(@RequestBody AgentEntity agent) {
        try {
        	AgentEntity loggedInCustomer = agentService.loginAgent(agent.getEmail(), agent.getPassword());
            return ResponseEntity.ok(loggedInCustomer); // Returns agent details if login is successful
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Returns error message
        }
    }
}
