package com.eivencrm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_role_menu", schema = "eivencrm", catalog = "")
@IdClass(SysRoleMenuEntityPK.class)
public class SysRoleMenuEntity {
    private long roleId;
    private long menuId;
    private Timestamp createTime;

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleMenuEntity that = (SysRoleMenuEntity) o;
        return roleId == that.roleId &&
                menuId == that.menuId &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, menuId, createTime);
    }
}
