package ba.biblioteka.assembler;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import ba.biblioteka.models.ClanBiblioteke;

@Component
public class ClanResourceAssembler implements ResourceAssembler<ClanBiblioteke, Resource<ClanBiblioteke>> {
	
	@Override
    public Resource<ClanBiblioteke> toResource(ClanBiblioteke customer) {
		
        Resource<ClanBiblioteke> resource = new Resource<>(customer);
        
        resource.add(new Link("http://administracija/clanovi/" + customer.getId()).withSelfRel());
        return resource;
    }
	
}
