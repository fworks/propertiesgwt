package com.github.fworks.propertiesgwt.client;

import java.util.Arrays;
import com.google.gwt.core.client.EntryPoint;
import elemental2.core.Global;
import elemental2.dom.DomGlobal;
import elemental2.dom.XMLHttpRequest;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class PropertiesGwt implements EntryPoint {

  PropertiesGwt() {
  }
  
  private static JsPropertyMap<Object> propertiesMap;
  
  @Override
  public void onModuleLoad() {
    XMLHttpRequest httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", "/propertiesGwt", false);
    httpRequest.onload = event -> {

      if (Arrays.asList(200, 201, 204).contains(httpRequest.status)) {
        String responseText = httpRequest.responseText;
        // if success
        try {
          // execute onSuccess
          propertiesMap = Js.asPropertyMap(Global.JSON.parse(responseText));
        } catch (Exception e) {
          DomGlobal.console.error("Error loading properties!", e);
        }
      } else {
        // if error
        DomGlobal.console.error("Error loading properties!" + httpRequest.status);
      }

    };

    httpRequest.addEventListener("error", event -> {
      DomGlobal.console.error("Error loading properties! Error: " + httpRequest.status + " " + httpRequest.statusText);
    });
    
    httpRequest.send();
  }
  
  public static String getValue(String propertyName) {
    return propertiesMap.get(propertyName) + "";
  }

}
