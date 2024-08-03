package com.invoice.roles.repositories;

import com.invoice.roles.models.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Long> {
    /*@Query("delete from role_permissions where role_id=role")
    void deleteRolPermision(Long role);
    @Modifying(clearAutomatically = true)*/
    @Modifying
    @Query(value = "delete from role_permissions where role_id=?1", nativeQuery = true)
    @Transactional
    void deleteAllByRoleID(Long role_id);
}
