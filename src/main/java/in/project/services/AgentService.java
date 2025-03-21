package in.project.services;

import java.util.List;
import java.util.Optional;

import in.project.entity.AgentEntity;

public interface AgentService {
	   public AgentEntity saveAgent(AgentEntity agent) throws Exception;
	   public List<AgentEntity> getAllAgents();
	   public Optional<AgentEntity> getAgentEmail(String email);
	   public Optional<AgentEntity> getAgentById(Long agentId);
	   public AgentEntity updateAgent(Long agentId, AgentEntity agent);
	   public void deleteAgent(Long agentId);
	public AgentEntity loginAgent(String email, String password) throws Exception ;
}
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
//<dependency>
//<groupId>org.thymeleaf.extras</groupId>
//<artifactId>thymeleaf-extras-springsecurity6</artifactId>
//</dependency>