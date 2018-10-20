package com.sky.hrpro.entity;

/**
 * @Author: CarryJey @Date: 2018/10/20 17:52:35
 */
public class MailRecordEntity {

    private long id;
    private String fromAddress;
    private String toAddress;
    private String content;
    private String title;
    private long createdTime;
    private long updatedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "MailRecordEntity{"
            + "id="
            + id
            + ", fromAddress='"
            + fromAddress
            + '\''
            + ", toAddress='"
            + toAddress
            + '\''
            + ", content='"
            + content
            + '\''
            + ", title='"
            + title
            + '\''
            + ", createdTime="
            + createdTime
            + ", updatedTime="
            + updatedTime
            + '}';
    }
}
