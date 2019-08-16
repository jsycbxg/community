package com.bxg.community.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Comment {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private Integer commentCount;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PARENT_ID")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    @Column(name = "COMMENTATOR")
    public Long getCommentator() {
        return commentator;
    }

    public void setCommentator(Long commentator) {
        this.commentator = commentator;
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
    @Column(name = "LIKE_COUNT")
    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "COMMENT_COUNT")
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(parentId, comment.parentId) &&
                Objects.equals(type, comment.type) &&
                Objects.equals(commentator, comment.commentator) &&
                Objects.equals(gmtCreate, comment.gmtCreate) &&
                Objects.equals(gmtModified, comment.gmtModified) &&
                Objects.equals(likeCount, comment.likeCount) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(commentCount, comment.commentCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, type, commentator, gmtCreate, gmtModified, likeCount, content, commentCount);
    }
}
