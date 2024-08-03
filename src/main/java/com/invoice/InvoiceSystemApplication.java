package com.invoice;

import com.invoice.roles.models.Permissions;
import com.invoice.roles.models.Roles;
import com.invoice.users.models.User;
import com.invoice.users.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Set;

@SpringBootApplication

public class InvoiceSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(InvoiceSystemApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			Permissions rBranch = Permissions.builder().name("READ_BRANCH").build();
			Permissions raBranch = Permissions.builder().name("READALL_BRANCH").build();
			Permissions cBranch = Permissions.builder().name("CREATE_BRANCH").build();
			Permissions uBranch = Permissions.builder().name("UPDATE_BRANCH").build();
			Permissions dBranch = Permissions.builder().name("DELETE_BRANCH").build();

			Permissions rBrand = Permissions.builder().name("READ_BRAND").build();
			Permissions raBrand = Permissions.builder().name("READALL_BRAND").build();
			Permissions cBrand = Permissions.builder().name("CREATE_BRAND").build();
			Permissions uBrand = Permissions.builder().name("UPDATE_BRAND").build();
			Permissions dBrand = Permissions.builder().name("DELETE_BRAND").build();

			Permissions rBuy = Permissions.builder().name("READ_BUY").build();
			Permissions raBuy = Permissions.builder().name("READALL_BUY").build();
			Permissions cBuy = Permissions.builder().name("CREATE_BUY").build();
			Permissions uBuy = Permissions.builder().name("UPDATE_BUY").build();
			Permissions dBuy= Permissions.builder().name("DELETE_BUY").build();

			Permissions rCateg = Permissions.builder().name("READ_CATEGORY").build();
			Permissions raCateg = Permissions.builder().name("READALL_CATEGORY").build();
			Permissions cCateg = Permissions.builder().name("CREATE_CATEGORY").build();
			Permissions uCateg = Permissions.builder().name("UPDATE_CATEGORY").build();
			Permissions dCateg = Permissions.builder().name("DELETE_CATEGORY").build();

			Permissions rCompan = Permissions.builder().name("READ_COMPANY").build();
			Permissions raCompan = Permissions.builder().name("READALL_COMPANY").build();
			Permissions cCompan = Permissions.builder().name("CREATE_COMPANY").build();
			Permissions uCompan = Permissions.builder().name("UPDATE_COMPANY").build();
			Permissions dCompan = Permissions.builder().name("DELETE_COMPANY").build();

			Permissions rDisc = Permissions.builder().name("READ_DISCOUNT").build();
			Permissions raDisc = Permissions.builder().name("READALL_DISCOUNT").build();
			Permissions cDisc = Permissions.builder().name("CREATE_DISCOUNT").build();
			Permissions uDisc = Permissions.builder().name("UPDATE_DISCOUNT").build();
			Permissions dDisc= Permissions.builder().name("DELETE_DISCOUNT").build();

			Permissions rInvent = Permissions.builder().name("READ_INVENTORY").build();
			Permissions raInvent = Permissions.builder().name("READALL_INVENTORY").build();
			Permissions cInvent = Permissions.builder().name("CREATE_INVENTORY").build();
			Permissions uInvent = Permissions.builder().name("UPDATE_INVENTORY").build();
			Permissions dInvent = Permissions.builder().name("DELETE_INVENTORY").build();

			Permissions rInvoic = Permissions.builder().name("READ_INVOICE").build();
			Permissions raInvoic = Permissions.builder().name("READALL_INVOICE").build();
			Permissions cInvoic = Permissions.builder().name("CREATE_INVOICE").build();
			Permissions uInvoic = Permissions.builder().name("UPDATE_INVOICE").build();
			Permissions dInvoic = Permissions.builder().name("DELETE_INVOICE").build();

			Permissions rPay = Permissions.builder().name("READ_PAY").build();
			Permissions raPay = Permissions.builder().name("READALL_PAY").build();
			Permissions cPay = Permissions.builder().name("CREATE_PAY").build();
			Permissions uPay = Permissions.builder().name("UPDATE_PAY").build();
			Permissions dPay= Permissions.builder().name("DELETE_PAY").build();

			Permissions rProduc = Permissions.builder().name("READ_PRODUCT").build();
			Permissions raProduc = Permissions.builder().name("READALL_PRODUCT").build();
			Permissions cProduc = Permissions.builder().name("CREATE_PRODUCT").build();
			Permissions uProduc = Permissions.builder().name("UPDATE_PRODUCT").build();
			Permissions dProduc = Permissions.builder().name("DELETE_PRODUCT").build();

			Permissions rProvide = Permissions.builder().name("READ_PROVIDER").build();
			Permissions raProvide = Permissions.builder().name("READALL_PROVIDER").build();
			Permissions cProvide = Permissions.builder().name("CREATE_PROVIDER").build();
			Permissions uProvide = Permissions.builder().name("UPDATE_PROVIDER").build();
			Permissions dProvide = Permissions.builder().name("DELETE_PROVIDER").build();

			Permissions rRol = Permissions.builder().name("READ_ROLE").build();
			Permissions raRol = Permissions.builder().name("READALL_ROLE").build();
			Permissions cRol = Permissions.builder().name("CREATE_ROLE").build();
			Permissions uRol = Permissions.builder().name("UPDATE_ROLE").build();
			Permissions dRol = Permissions.builder().name("DELETE_ROLE").build();

			Permissions rTax = Permissions.builder().name("READ_TAX").build();
			Permissions raTax = Permissions.builder().name("READALL_TAX").build();
			Permissions cTax = Permissions.builder().name("CREATE_TAX").build();
			Permissions uTax = Permissions.builder().name("UPDATE_TAX").build();
			Permissions dTax = Permissions.builder().name("DELETE_TAX").build();

			Permissions rUser = Permissions.builder().name("READ_USER").build();
			Permissions raUser = Permissions.builder().name("READALL_USER").build();
			Permissions cUser = Permissions.builder().name("CREATE_USER").build();
			Permissions uUser = Permissions.builder().name("UPDATE_USER").build();
			Permissions dUser = Permissions.builder().name("DELETE_USER").build();
			Permissions dUserRol = Permissions.builder().name("ROLE_USER").build();

			Roles rol = Roles.builder()
					.name("ADMIN")
					.permissionList(Set.of(rBrand, raBrand, cBrand, uBrand,dBrand,
							rBuy, raBuy, cBuy, uBuy,dBuy,
							rBranch, raBranch, cBranch, uBranch,dBranch,
							rCateg, raCateg, cCateg, uCateg,dCateg,
							rCompan, raCompan, cCompan, uCompan,dCompan,
							rDisc, raDisc, cDisc, uDisc,dDisc,
							rInvent, raInvent, cInvent, uInvent,dInvent,
							rInvoic, raInvoic, cInvoic, uInvoic,dInvoic,
							rPay, raPay, cPay, uPay,dPay,
							rProduc, raProduc, cProduc, uProduc,dProduc,
							rProvide, raProvide, cProvide, uProvide,dProvide,
							rRol, raRol, cRol, uRol,dRol,
							rTax, raTax, cTax, uTax,dTax,
							rUser, raUser, cUser, uUser,dUser,dUserRol))
					.build();

			User user = User.builder()
					.email("r@r.com")
					.username("admin")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rol))
					.build();
			userRepository.saveAll(List.of(user));
		};
	}*/
}