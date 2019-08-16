package com.bxg.community.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Notification {
    private Long id;
    private Long notifier;
    private Long receiver;
    private Long outerid;
    private Integer type;
    private Long gmtCreate;
    private Integer status;
    private String notifierName;
    private String outerTitle;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOTIFIER")
    public Long getNotifier() {
        return notifier;
    }

    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    @Basic
    @Column(name = "RECEIVER")
    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "OUTERID")
    public Long getOuterid() {
        return outerid;
    }

    public void setOuterid(Long outerid) {
        this.outerid = outerid;
    }

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "GMT_CREATE")
    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "NOTIFIER_NAME")
    public String getNotifierName() {
        return notifierName;
    }

    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName;
    }

    @Basic
    @Column(name = "OUTER_TITLE")
    public String getOuterTitle() {
        return outerTitle;
    }

    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(notifier, that.notifier) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(outerid, that.outerid) &&
                Objects.equals(type, that.type) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(notifierName, that.notifierName) &&
                Objects.equals(outerTitle, that.outerTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notifier, receiver, outerid, type, gmtCreate, status, notifierName, outerTitle);
    }
}
