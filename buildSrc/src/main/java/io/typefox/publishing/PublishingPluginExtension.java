/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package io.typefox.publishing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.gradle.api.Action;

import groovy.lang.Closure;

public class PublishingPluginExtension {
	private String version;

	private String branch = "master";

	private MavenUploadRepository mavenUploadRepository = new MavenUploadRepository();

	private boolean createSignatures = true;

	private boolean signJars = false;

	private boolean packJars = false;

	private boolean failOnInconsistentJars = false;

	private final List<MavenProject> projects = new ArrayList<>();

	private File userMavenSettings = new File(System.getProperty("user.home"), ".m2/settings.xml");

	private File globalMavenSettings = new File(System.getenv("M2_HOME"), "conf/settings.xml");

	private File mavenSecurityFile = new File(System.getProperty("user.home"), "/.m2/settings-security.xml");

	private final List<P2Repository> p2Repositories = new ArrayList<>();

	public void version(Object input) {
		version = input.toString();
	}

	public String getBaseVersion() {
		if (version.endsWith("-SNAPSHOT")) {
			return version.substring(0, version.length() - "-SNAPSHOT".length());
		} else {
			if (version.split("\\.").length == 3) {
				return version;
			} else {
				return version.substring(0, version.lastIndexOf("."));
			}
		}
	}

	public void branch(Object input) {
		branch = input.toString();
	}

	public MavenUploadRepository mavenUploadRepository(String name) {
		MavenUploadRepository result = new MavenUploadRepository();
		result.name(name);
		mavenUploadRepository = result;
		return result;
	}

	public MavenUploadRepository mavenUploadRepository(Closure<MavenUploadRepository> configure) {
		MavenUploadRepository result = new MavenUploadRepository();
		configure.setDelegate(result);
		configure.setResolveStrategy(Closure.DELEGATE_FIRST);
		configure.call();
		mavenUploadRepository = result;
		return result;
	}

	public MavenUploadRepository mavenUploadRepository(Action<MavenUploadRepository> configure) {
		MavenUploadRepository result = new MavenUploadRepository();
		configure.execute(result);
		mavenUploadRepository = result;
		return result;
	}

	public void createSignatures(Object input) {
		if (input instanceof Boolean) {
			createSignatures = ((Boolean) input).booleanValue();
		} else {
			if (input instanceof String) {
				createSignatures = Boolean.parseBoolean((String) input);
			}
		}
	}

	public void signJars(Object input) {
		if (input instanceof Boolean) {
			signJars = ((Boolean) input).booleanValue();
		} else {
			if (input instanceof String) {
				signJars = Boolean.parseBoolean((String) input);
			}
		}
	}

	public void packJars(Object input) {
		if (input instanceof Boolean) {
			packJars = ((Boolean) input).booleanValue();
		} else {
			if (input instanceof String) {
				packJars = Boolean.parseBoolean((String) input);
			}
		}
	}

	public void failOnInconsistentJars(Object input) {
		if (input instanceof Boolean) {
			failOnInconsistentJars = ((Boolean) input).booleanValue();
		} else {
			if (input instanceof String) {
				failOnInconsistentJars = Boolean.parseBoolean((String) input);
			}
		}
	}

	public MavenProject project(Closure<MavenProject> configure) {
		MavenProject result = new MavenProject();
		configure.setDelegate(result);
		configure.setResolveStrategy(Closure.DELEGATE_FIRST);
		configure.call();
		projects.add(result);
		return result;
	}

	public MavenProject project(Action<MavenProject> configure) {
		MavenProject result = new MavenProject();
		configure.execute(result);
		projects.add(result);
		return result;
	}

	public File userMavenSettings(Object input) {
		if (input instanceof File) {
			return userMavenSettings = (File) input;
		} else {
			return userMavenSettings = new File(input.toString());
		}
	}

	public File globalMavenSettings(Object input) {
		if (input instanceof File) {
			return globalMavenSettings = (File) input;
		} else {
			return globalMavenSettings = new File(input.toString());
		}
	}

	public File mavenSecurityFile(Object input) {
		if (input instanceof File) {
			return mavenSecurityFile = (File) input;
		} else {
			return mavenSecurityFile = new File(input.toString());
		}
	}

	public P2Repository p2Repository(Closure<P2Repository> configure) {
		P2Repository result = new P2Repository();
		configure.setDelegate(result);
		configure.setResolveStrategy(Closure.DELEGATE_FIRST);
		configure.call();
		p2Repositories.add(result);
		return result;
	}

	public P2Repository p2Repository(Action<P2Repository> configure) {
		P2Repository result = new P2Repository();
		configure.execute(result);
		p2Repositories.add(result);
		return result;
	}

	public String getVersion() {
		return version;
	}

	public String getBranch() {
		return branch;
	}

	public MavenUploadRepository getMavenUploadRepository() {
		return mavenUploadRepository;
	}

	public boolean isCreateSignatures() {
		return createSignatures;
	}

	public boolean isSignJars() {
		return signJars;
	}

	public boolean isPackJars() {
		return packJars;
	}

	public boolean isFailOnInconsistentJars() {
		return failOnInconsistentJars;
	}

	public List<MavenProject> getProjects() {
		return projects;
	}

	public File getUserMavenSettings() {
		return userMavenSettings;
	}

	public File getGlobalMavenSettings() {
		return globalMavenSettings;
	}

	public File getMavenSecurityFile() {
		return mavenSecurityFile;
	}

	public List<P2Repository> getP2Repositories() {
		return p2Repositories;
	}
}
