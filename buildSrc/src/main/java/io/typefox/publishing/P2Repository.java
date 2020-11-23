/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package io.typefox.publishing;

import java.util.ArrayList;
import java.util.List;

public class P2Repository {
  private String name;
  
  private String group;
  
  private String url;
  
  private String deployPath;
  
  private final List<String> namespaces = new ArrayList<>();
  
  private String referenceFeature;
  
  private final List<String> acceptedDifferingJars = new ArrayList<>();
  
  public void name(Object input) {
    name = input.toString();
  }
  
  public void group(Object input) {
    group = input.toString();
  }
  
  public void url(Object input) {
    url = input.toString();
  }
  
  public void deployPath(Object input) {
    deployPath = input.toString();
  }
  
  public void namespace(Object input) {
    namespaces.add(input.toString());
  }
  
  public void referenceFeature(Object input) {
    referenceFeature = input.toString();
  }
  
  public void acceptDifferingJars(Object input) {
    acceptedDifferingJars.add(input.toString());
  }
  
  public String getName() {
    return name;
  }
  
  public String getGroup() {
    return group;
  }
  
  public String getUrl() {
    return url;
  }
  
  public String getDeployPath() {
    return deployPath;
  }
  
  public List<String> getNamespaces() {
    return namespaces;
  }
  
  public String getReferenceFeature() {
    return referenceFeature;
  }
  
  public List<String> getAcceptedDifferingJars() {
    return acceptedDifferingJars;
  }
}
