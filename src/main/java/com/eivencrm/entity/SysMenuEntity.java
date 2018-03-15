package com.eivencrm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_menu", schema = "eivencrm", catalog = "")
public class SysMenuEntity {
    private long id;
    private Long parentId;
    private String parentIds;
    private String name;
    private String url;
    private String icon;
    private Integer sort;
    private String status;
    private String permission;
    private String remark;
    private String type;
    private String open;
    private String bapid;
    private String baid;
    private String updateId;
    private Timestamp updateTime;
    private String createId;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "parent_ids")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "open")
    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    @Basic
    @Column(name = "bapid")
    public String getBapid() {
        return bapid;
    }

    public void setBapid(String bapid) {
        this.bapid = bapid;
    }

    @Basic
    @Column(name = "baid")
    public String getBaid() {
        return baid;
    }

    public void setBaid(String baid) {
        this.baid = baid;
    }

    @Basic
    @Column(name = "update_id")
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "create_id")
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
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
        SysMenuEntity that = (SysMenuEntity) o;
        return id == that.id &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(parentIds, that.parentIds) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(status, that.status) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(type, that.type) &&
                Objects.equals(open, that.open) &&
                Objects.equals(bapid, that.bapid) &&
                Objects.equals(baid, that.baid) &&
                Objects.equals(updateId, that.updateId) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(createId, that.createId) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, parentIds, name, url, icon, sort, status, permission, remark, type, open, bapid, baid, updateId, updateTime, createId, createTime);
    }
}
