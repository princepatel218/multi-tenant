package com.learn.multitenant.service;

import com.learn.multitenant.domain.Permission;
import com.learn.multitenant.domain.Role;
import com.learn.multitenant.domain.User;
import com.learn.multitenant.repository.PermissionRepository;
import com.learn.multitenant.repository.RoleRepository;
import com.learn.multitenant.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostConstructInitiate {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;


    @PostConstruct
    public void init() {
        createRoles();
        createPermissions();
        registerUsers();
    }


    private void registerUsers() {
        long count = userRepository.count();

        if (count == 0) {
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@admin.com");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setIsActive(true);
            user.setTenantId(UUID.fromString("4e55198b-3f70-4479-b0c4-5127139664e4"));
            userRepository.save(user);

            User user1 = new User();
            user1.setName("User");
            user1.setEmail("user@user.com");
            user1.setPassword(new BCryptPasswordEncoder().encode("user"));
            user1.setIsActive(true);
            user1.setTenantId(UUID.fromString("4e55198b-3f70-4479-b0c4-5127139664e4"));
            userRepository.save(user1);

            User user2 = new User();
            user2.setName("Manager");
            user2.setEmail("manager@manager.com");
            user2.setPassword(new BCryptPasswordEncoder().encode("manager"));
            user2.setIsActive(true);
            user2.setTenantId(UUID.fromString("4e55198b-3f70-4479-b0c4-5127139664e4"));
            userRepository.save(user2);

            User user3 = new User();
            user3.setName("Another Admin");
            user3.setEmail("admin2@admin.com");
            user3.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user3.setIsActive(true);
            user3.setTenantId(UUID.fromString("0625c41e-fab6-4c8f-af18-458bea131a8a"));
            userRepository.save(user3);
        }

    }

    private void createRoles() {
        if (roleRepository.count() == 0) {
            Role role = new Role();
            role.setName("ADMIN");
            roleRepository.save(role);

            Role role1 = new Role();
            role1.setName("MANAGER");
            roleRepository.save(role1);

            Role role2 = new Role();
            role2.setName("USER");
            roleRepository.save(role2);
        }
    }

    private void createPermissions() {
        if (permissionRepository.count() == 0) {
            Permission permission = new Permission();
            permission.setName("VIEW_SOME_TABLE");
            permissionRepository.save(permission);

            Permission permission1 = new Permission();
            permission1.setName("WRITE_SOME_TABLE");
            permissionRepository.save(permission1);

            Permission permission2 = new Permission();
            permission2.setName("VIEW_SOME_OTHER_TABLE");
            permissionRepository.save(permission2);

            Permission permission3 = new Permission();
            permission3.setName("WRITE_SOME_OTHER_TABLE");
            permissionRepository.save(permission3);
        }
    }

}
