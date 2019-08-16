package com.bxg.community.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private Long id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String bio;
    private String avatarUrl;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCOUNT_ID")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
    @Column(name = "GMT_MODIFIED")
    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "BIO")
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Basic
    @Column(name = "AVATAR_URL")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(accountId, user.accountId) &&
                Objects.equals(name, user.name) &&
                Objects.equals(token, user.token) &&
                Objects.equals(gmtCreate, user.gmtCreate) &&
                Objects.equals(gmtModified, user.gmtModified) &&
                Objects.equals(bio, user.bio) &&
                Objects.equals(avatarUrl, user.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, name, token, gmtCreate, gmtModified, bio, avatarUrl);
    }
}
