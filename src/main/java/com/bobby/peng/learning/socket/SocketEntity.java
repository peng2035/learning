package com.bobby.peng.learning.socket;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class SocketEntity implements Serializable{

    private static final long serialVersionUID = -6989804490329058777L;

    private int id;

    private String className;

    private String methodName;

    private List<Parameter> parameters;

    public SocketEntity() {
    }

    public SocketEntity(int id, String className, String methodName) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
    }

    public SocketEntity(int id, String className, String methodName, List<Parameter> parameters) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
