package com.moller.Models;

public class MetadataObject {
    private Integer metadataId;
    private String metadataTag;
    private String valueType;
    private Integer valueLength;

    /**
     * A single tag, comprised of its name, the metadata ID value, as well as what
     * kind of datatype the tag accepts,
     * alongside the maximum length of the value.
     *
     * @param id     TagID, e.g. "0x0001."
     * @param tag    Specification name of the tag.
     * @param type   What kind of value the tag accepts.
     * @param length How many characters are allowed. A length of 0 means no limit.
     */
    public MetadataObject(Integer id, String tag, String type, Integer length) {
        metadataId = id;
        metadataTag = tag;
        valueType = type;
        valueLength = length;
    }

    public Integer getMetadataId() {
        return metadataId;
    }

    public String getMetadataTag() {
        return metadataTag;
    }

    public String getValueType() {
        return valueType;
    }

    public Integer getValueLength() {
        return valueLength;
    }
}
