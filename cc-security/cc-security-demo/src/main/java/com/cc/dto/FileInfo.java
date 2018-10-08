package com.cc.dto;

public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public FileInfo setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FileInfo{");
        sb.append("path='").append(path).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
