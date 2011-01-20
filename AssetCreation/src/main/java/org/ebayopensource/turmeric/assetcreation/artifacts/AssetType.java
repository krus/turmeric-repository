/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.29 at 04:38:16 AM PDT 
//


package org.ebayopensource.turmeric.assetcreation.artifacts;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for AssetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Functional Domain"/>
 *     &lt;enumeration value="Consumer"/>
 *     &lt;enumeration value="Property"/>
 *     &lt;enumeration value="Flag"/>
 *     &lt;enumeration value="Flag Set"/>
 *     &lt;enumeration value="Feature Contingency"/>
 *     &lt;enumeration value="Command"/>
 *     &lt;enumeration value="Deliverable"/>
 *     &lt;enumeration value="Search Driver"/>
 *     &lt;enumeration value="Page"/>
 *     &lt;enumeration value="Page Group"/>
 *     &lt;enumeration value="Template"/>
 *     &lt;enumeration value="Module"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum AssetType {

    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Functional Domain")
    FUNCTIONAL_DOMAIN("Functional Domain"),
    @XmlEnumValue("Consumer")
    CONSUMER("Consumer"),
    @XmlEnumValue("Property")
    PROPERTY("Property"),
    @XmlEnumValue("Flag")
    FLAG("Flag"),
    @XmlEnumValue("Flag Set")
    FLAG_SET("Flag Set"),
    @XmlEnumValue("Feature Contingency")
    FEATURE_CONTINGENCY("Feature Contingency"),
    @XmlEnumValue("Command")
    COMMAND("Command"),
    @XmlEnumValue("Deliverable")
    DELIVERABLE("Deliverable"),
    @XmlEnumValue("Search Driver")
    SEARCH_DRIVER("Search Driver"),
    @XmlEnumValue("Page")
    PAGE("Page"),
    @XmlEnumValue("Page Group")
    PAGE_GROUP("Page Group"),
    @XmlEnumValue("Template")
    TEMPLATE("Template"),
    @XmlEnumValue("Module")
    MODULE("Module");
    private final String value;

    AssetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssetType fromValue(String v) {
        for (AssetType c: AssetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
