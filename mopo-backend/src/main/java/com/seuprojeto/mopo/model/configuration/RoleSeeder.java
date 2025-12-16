package com.seuprojeto.mopo.model.configuration;

import com.seuprojeto.mopo.model.Role;
import com.seuprojeto.mopo.model.shared.RoleName;
import com.seuprojeto.mopo.repository.IRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final IRoleRepository roleRepository;

    public RoleSeeder(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        createRoleIfNotExists("ROLE_CLIENT");
        createRoleIfNotExists("ROLE_NUTRITIONIST");
        createRoleIfNotExists("ROLE_ENTERPRISE");
        createRoleIfNotExists("ROLE_DELIVERY");
    }

    private void createRoleIfNotExists(String roleName) {
        if (roleRepository.findByRoleName(RoleName.valueOf(roleName)).isEmpty()) {
            Role role = new Role();
            role.setRoleName(RoleName.valueOf(roleName));
            roleRepository.save(role);
            System.out.println("Criada: " + roleName);
        }
    }
}

