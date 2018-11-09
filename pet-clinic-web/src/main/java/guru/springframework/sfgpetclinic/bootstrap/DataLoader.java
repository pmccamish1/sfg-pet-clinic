package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}


	public void run(String... args) throws Exception {
		Owner o1 = new Owner();
		o1.setFirstName("me");
		o1.setLastName("too");
		
		Owner o2 = new Owner();
		o2.setFirstName("him");
		o2.setLastName("also");
		
		ownerService.save(o1);
		ownerService.save(o2);
		System.out.println("Loaded owners");
		
		Vet v1 = new Vet();
		v1.setFirstName("first");
		v1.setLastName("vet");
		
		Vet v2 = new Vet();
		v2.setFirstName("Ilike");
		v2.setLastName("animals");
		
		vetService.save(v1);
		vetService.save(v2);
		System.out.println("Loaded vets");
	}

}
