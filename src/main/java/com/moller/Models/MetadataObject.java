package com.moller.Models;

public class MetadataObject {
    private Integer metadataId;
    private String metadataTag;
    private Object writeTag;

    public MetadataObject(Integer id, String tag, Object writable) {
        metadataId = id;
        metadataTag = tag;
        writeTag = writable;
    }

    public Integer getMetadataId() {
        return metadataId;
    }

    public String getMetadataTag() {
        return metadataTag;
    }

    public Object writeTag() {
        return writeTag;
    }
}
