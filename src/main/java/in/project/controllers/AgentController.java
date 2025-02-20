package in.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.project.entity.AgentEntity;
import in.project.services.AgentService;

@RestController
@RequestMapping("/agents")
public class AgentController {
    
    @Autowired
    private AgentService agentService;
    
    @PostMapping(value = "/data", consumes = {"application/json", "application/xml"}, produces = "text/plain")
    public ResponseEntity<AgentEntity> createAgent(@RequestBody AgentEntity agent) {
        return ResponseEntity.ok(agentService.saveAgent(agent));
//    	return new ResponseEntity<AgentEntity>(agentService.saveAgent(agent), HttpStatus.OK);

    }

    
    @GetMapping("/")
    public ResponseEntity<List<AgentEntity>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }
   
    @GetMapping("/{agentId}")
    public ResponseEntity<Optional<AgentEntity>> getAgentById(@PathVariable Long agentId) {
        return ResponseEntity.ok(agentService.getAgentById(agentId));
    }
    
    @PutMapping("/{agentId}")
    public ResponseEntity<AgentEntity> updateAgent(@PathVariable Long agentId, @RequestBody AgentEntity agent) {
        AgentEntity updatedAgent = agentService.updateAgent(agentId, agent);
        return updatedAgent != null ? ResponseEntity.ok(updatedAgent) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long agentId) {
        agentService.deleteAgent(agentId);
        return ResponseEntity.noContent().build();
    }
}
