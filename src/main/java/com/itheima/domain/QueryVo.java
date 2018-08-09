package com.itheima.domain;


import java.util.Date;

public class QueryVo {
    private User user;
    private Date start;
    private Date end;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
