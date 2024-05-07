package com.learn.multitenant.service;

import com.learn.multitenant.domain.*;
import com.learn.multitenant.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = optionalUser.get();

        List<UserRole> userRoles = userRoleRepository.findAllByUserId(user.getId());
        if(userRoles.isEmpty()){
            throw new RuntimeException("No roles assigned to user: " + email);
        } else {
            Set<Long> roleIdList = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
            List<Long> permissionIdList = rolePermissionRepository.findAllByRoleIdIn(roleIdList).stream()
                    .map(RolePermission::getPermissionId).toList();
            List<Permission> permissions = permissionRepository.findAllById(permissionIdList);
            if(permissions.isEmpty()) {
                throw new RuntimeException("No permissions assigned to user: " + email);
            }
            List<String> permissionNames = permissions.stream().map(Permission::getName).toList();
            return new UserDetailsImpl(user.getEmail(), user.getPassword(), permissionNames, user.getTenantId(), user.getId());
        }
    }
}
