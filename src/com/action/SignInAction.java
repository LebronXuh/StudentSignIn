package com.action;

import com.model.StudentEntity;
import com.opensymphony.xwork2.ActionContext;
import service.FaceSerachServer;
import service.impl.FaceSearcherverImpl;

import java.util.Map;

public class SignInAction {
    private String face;//Base64编码图片

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String execute() throws Exception {
        FaceSerachServer faceSeracherver = new FaceSearcherverImpl();
        StudentEntity student = faceSeracherver.FindStudentByFace(this.face);
        if (student != null) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("student",student);
            return "success";
        } else
            return "fail";
    }
}