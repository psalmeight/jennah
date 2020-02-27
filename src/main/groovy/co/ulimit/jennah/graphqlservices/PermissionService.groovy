package co.ulimit.jennah.graphqlservices


import co.ulimit.jennah.domain.Permission
import co.ulimit.jennah.repository.PermissionRepository
import groovy.transform.TypeChecked
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@TypeChecked
@Component
@GraphQLApi
class PermissionService {
	
	@Autowired
	private PermissionRepository permissionRepository
	
	//============== All Queries ====================
	
	@GraphQLQuery(name = "permissions", description = "Get all Permissions")
	List<Permission> findAll() {
		return permissionRepository.findAll()
	}
}
